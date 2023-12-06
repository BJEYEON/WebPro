package com.example.world.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.world.dto.Cart2VO;
import com.example.world.dto.KakaoProfile;
import com.example.world.dto.KakaoProfile.KakaoAccount;
import com.example.world.dto.KakaoProfile.KakaoAccount.Profile;
import com.example.world.dto.MemberVO;
import com.example.world.dto.OAuthToken;
import com.example.world.dto.Paging;
import com.example.world.service.MemberService;
import com.google.gson.Gson;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping("loginForm")
	public String login_form() {
		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result, Model model,
			HttpServletRequest request) {
		String url = "member/login";
		if (result.getFieldError("id") != null)
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
		else if (result.getFieldError("pwd") != null)
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
		else {

			MemberVO mvo = ms.getMember(membervo.getId());
			if (mvo == null)
				model.addAttribute("message", "ID가 없습니다");
			else if (mvo.getPwd() == null)
				model.addAttribute("message", "관리자에게 문의하세요");
			else if (!mvo.getPwd().equals(membervo.getPwd()))
				model.addAttribute("message", "암호가 잘못되었습니다");
			else if( mvo.getUseyn().equals("N") )
				model.addAttribute("message", "회원 가입 및 탈퇴 이력이 있는 사용자입니다. 재가입은 관리자에게 문의하세요");
			else if (mvo.getPwd().equals(membervo.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", mvo);
				url = "redirect:/";
			}
		}
		return url;
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}

	@RequestMapping("/kakaostart")
	public @ResponseBody String kakaostart() {
		String a = "<script type='text/javascript'>" + "location.href='https://kauth.kakao.com/oauth/authorize?"
				+ "client_id=fb58d066fb2ae98931cb969be61cf039&" + "redirect_uri=http://localhost:8070/kakaoLogin&"
				+ "response_type=code';" + "</script>";
		return a;
	}

	@RequestMapping("/kakaoLogin")
	public String loginKakao(HttpServletRequest request) throws UnsupportedEncodingException, IOException {

		
		String code = request.getParameter("code");
		
		String endpoint = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(endpoint); // import java.net.URL;
		String bodyData = "grant_type=authorization_code&";
		bodyData += "client_id=fb58d066fb2ae98931cb969be61cf039&";
		bodyData += "redirect_uri=http://localhost:8070/kakaoLogin&";
		bodyData += "code=" + code;
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // import java.net.HttpURLConnection;
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.write(bodyData);
		bw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder(); // 조각난 String 을 조립하기위한 객체
		while ((input = br.readLine()) != null) {
			sb.append(input);
			System.out.println(input); // 수신된 토큰을 콘솔에 출력합니다
		}
		

		
		Gson gson = new Gson();
		OAuthToken oAuthToken = gson.fromJson(sb.toString(), OAuthToken.class);

		
		String endpoint2 = "https://kapi.kakao.com/v2/user/me";
		URL url2 = new URL(endpoint2);
		
		HttpsURLConnection conn2 = (HttpsURLConnection) url2.openConnection();
		conn2.setRequestProperty("Authorization", "Bearer " + oAuthToken.getAccess_token());
		conn2.setDoOutput(true);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream(), "UTF-8"));
		String input2 = "";
		StringBuilder sb2 = new StringBuilder();
		while ((input2 = br2.readLine()) != null) {
			sb2.append(input2);
			System.out.println(input2);
		}
	

		
		Gson gson2 = new Gson();
		KakaoProfile kakaoProfile = gson2.fromJson(sb2.toString(), KakaoProfile.class);

		System.out.println(kakaoProfile.getId());
		KakaoAccount ac = kakaoProfile.getAccount();
		System.out.println(ac.getEmail());
		Profile pf = ac.getProfile();
		System.out.println(pf.getNickname());

		MemberVO mvo = ms.getMember(kakaoProfile.getId());
		if (mvo == null) {
			mvo = new MemberVO();
			mvo.setId(kakaoProfile.getId());
			mvo.setEmail(ac.getEmail());
			mvo.setName(pf.getNickname());
			mvo.setProvider("kakao");
			ms.joinKakao(mvo);
		}

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", mvo);

		return "redirect:/";
	}

	@RequestMapping("/contract")
	public String contract() {
		return "member/contract";
	}

	@RequestMapping("/joinForm")
	public String join_form() {
		return "member/join";
	}

	@RequestMapping("idCheckForm")
	public String id_check_form(@RequestParam("id") String id, Model model) {
		MemberVO mvo = ms.getMember(id);
		int result = 0;
		if (mvo == null)
			result = -1;
		else
			result = 1;
		model.addAttribute("result", result);
		model.addAttribute("id", id);
		return "member/idcheck";
	}

	@RequestMapping(value = "join", method=RequestMethod.POST)
	public String join(
					@ModelAttribute("dto") @Valid MemberVO membervo,
					BindingResult result, Model model, HttpServletRequest request, 
					@RequestParam("reid") String reid, @RequestParam("pwdCheck") String pwdCheck) {
		
		model.addAttribute("reid", reid);
		String url = "member/joinForm";
		
		if( result.getFieldError("id")!=null) 
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
		else if( result.getFieldError("pwd")!=null) 
			model.addAttribute("message", result.getFieldError("pwd").getDefaultMessage());
		else if( result.getFieldError("name")!=null) 
			model.addAttribute("message", result.getFieldError("name").getDefaultMessage());
		else if( result.getFieldError("email")!=null) 
			model.addAttribute("message", result.getFieldError("email").getDefaultMessage());
		else if( !reid.equals(membervo.getId()) ) 
			model.addAttribute("message", "id 중복체크를 하지 않았습니다");
		else if( !pwdCheck.equals( membervo.getPwd() ) ) 
			model.addAttribute("message", "비밀번호 확인이 일치하지 않습니다");
		else {
			model.addAttribute("message", "회원가입이 완료되었습니다. 로그인 하세요");
			ms.insertMember(membervo);
			url = "member/login";
		}
		return url;
	}
	
	
	
	@RequestMapping("/editForm")
	public String member_Edit_Form(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		model.addAttribute("dto", mvo);
		
		return "member/updateForm";
	}

	
	@RequestMapping(value = "memberUpdate",  method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute("dto") @Valid MemberVO membervo,
			BindingResult result, Model model, HttpServletRequest request,
			@RequestParam(value="pwdCheck", required=false) String pwdCheck ) {
		
		String url = "member/updateForm";
		
		if( membervo.getProvider()==null) {
			
			if( result.getFieldError("pwd")!=null ) 
				request.setAttribute("message", "비밀번호를 입력하세요");
			else if( !pwdCheck.equals( membervo.getPwd() ) ) 
				request.setAttribute("message", "비밀번호 확인이 일치하지 않습니다");
			else if( result.getFieldError("name")!=null) {
				request.setAttribute("message", result.getFieldError("name").getDefaultMessage());
			}else{
				ms.updateMember(membervo);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", membervo);
				url="redirect:/";
			}
			
		}else {
			
			if( result.getFieldError("name")!=null ) 
				request.setAttribute("message", result.getFieldError("name").getDefaultMessage());
			else {
				ms.updateMember(membervo);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", membervo);
				url="redirect:/";
			}
		}
		
		return url;
	}
	

	
	@RequestMapping("/selectId")
	public String selectId() {
		return "member/findId";	
 	}
	
	
	@RequestMapping("/re")
	public String re(
			HttpServletRequest request , Model model,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone
			) {
		
		if (name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
	          MemberVO member = ms.selectId(name, phone);
	          if( member==null) {
	        	  model.addAttribute("message", "일치하는 정보가 없습니다");
	          }else {
	        	  model.addAttribute("Lmember", member);
	          }
	          
	          //System.out.println(member.getName());
	         //System.out.println(member.getPhone());
	      }
		
		return "member/findId";	
 	}
	
	
	@RequestMapping("/selectPwd")
	public String selectPwd() {
		return "member/findPwd";	
 	}
	
	
	@RequestMapping("/re2")
	public String re2(
			HttpServletRequest request , Model model,
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone
			) {
		
		 if (id != null && !id.isEmpty() && name != null && !name.isEmpty() && phone != null && !phone.isEmpty()) {
			 MemberVO member = ms.selectPwd(id, name, phone);
	          if( member==null) {
	        	  model.addAttribute("message", "일치하는 정보가 없습니다");
	          }else {
	        	  model.addAttribute("Lmember", member);
	          }
	         
	      }
		
		return "member/findPwd";	
 	}
	
	
	@RequestMapping("/resetPwdForm")
	public String resetPwdForm() {
		return "member/resetPwd";	
 	}
	
	
	@RequestMapping("/re3")
	public String re3(
			 Model model, HttpServletResponse response,
			@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			MemberVO membervo
			) {
		
			ms.resetNewPwd(membervo);
		    
		  	model.addAttribute("message", "비밀번호 변경이 완료되었습니다.");
	        
		return "member/findPwd";	
 	}
	
//	@RequestMapping(value = "/re3", method = RequestMethod.POST)
//	public String resetPwd(@ModelAttribute("dto") @Valid MemberVO membervo,
//	BindingResult result, Model model, HttpServletRequest request,
//	@RequestParam("id") String id,
//	@RequestParam("pwd") String pwd,
//	@RequestParam("pwdCheck") String pwdCheck) {
//		String url = "member/findPwd";
//		if (result.getFieldError("pwd") != null) {
//		    model.addAttribute("message", "비밀번호를 입력해주세요.");
//		    model.addAttribute("result", 0);
//		    return url;
//		} else if (!pwd.equals(pwdCheck)) {
//		    model.addAttribute("message", "비밀번호 확인이 일치하지 않습니다.");
//		    model.addAttribute("result", 0);
//		    return url;
//		}
//
//		membervo.setId(id);
//		ms.resetNewPwd(id, pwd);
//
//		model.addAttribute("result", 3);
//		model.addAttribute("message", "비밀번호 변경이 완료되었습니다.");
//
//		return url;
//	}
	
	
	
	
	@RequestMapping("/cartList")
	public ModelAndView cartList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo==null)
			mav.setViewName("redirect:/login");
		else {
			int page = 1;
	        session.setAttribute("page", page);
	        
			HashMap<String, Object> result =  ms.getCartList( request );
			mav.addObject("cartList",  (List<Cart2VO>)result.get("cartList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("mypage/cartList");
			// Controller 는 Service 가 작업해서 보내준 결과들을 mav 에 잘 넣어서 목적지로 이동만 합니다.
		}
		return mav;	
	}
	
	@RequestMapping("/deleteMember")
	public String deleteMember( HttpServletRequest request , Model model) {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		ms.withdrawalMember( mvo.getId() );
		model.addAttribute("message" , "회원탈퇴가 정상적으로 처리되었습니다");
		session.removeAttribute("loginUser");
		return "member/login";
	}
	
	
}


















