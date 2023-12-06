package com.example.world.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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

import com.example.world.dto.AdminVo;
import com.example.world.dto.AttractionVO;
import com.example.world.dto.BannerVO;
import com.example.world.dto.Cart2VO;
import com.example.world.dto.MemberVO;
import com.example.world.dto.NoticeVO;
import com.example.world.dto.Paging;
import com.example.world.dto.QnaVO;
import com.example.world.service.AdminService;
import com.example.world.service.AttractionService;
import com.example.world.service.NoticeService;
import com.example.world.service.QnaService;
import com.example.world.service.TicketService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/adminLogin/adminLoginForm";
	}
	
	@RequestMapping("/adminlogin")
	public ModelAndView admin_login(
						@RequestParam(value="id", required=false) String workId,
						@RequestParam(value="name", required=false) String workName,
						@RequestParam(value="pwd", required=false) String workPwd, 
						HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		if( workId == null ) {
			mav.addObject("msg" , "아이디를 입력하세요");
			mav.setViewName("admin/adminLogin/adminLoginForm");
			return mav;
		}else if( workId.equals("") ) {
			mav.addObject("msg" , "아이디를 입력하세요");
			mav.setViewName("admin/adminLogin/adminLoginForm");
			return mav;
		}else if( workPwd == null) {
			mav.addObject("msg" , "패스워드를 입력하세요");
			mav.setViewName("admin/adminLogin/adminLoginForm");
			return mav;
		}else if( workPwd.equals("")) {
			mav.addObject("msg" , "패스워드를 입력하세요");
			mav.setViewName("admin/adminLogin/adminLoginForm");
			return mav;
		}
		
		int result = as.workerCheck( workId, workPwd, workName );
		
		if(result == 1) {
	    		HttpSession session = request.getSession();
	    		session.setAttribute("workId", workId);
	    		
	    		String name = as.getName(workId);
	    		session.setAttribute("name", name);
	    		
	    		mav.setViewName("redirect:/adminMain");
		} else if (result == 0) {
	        	mav.addObject("message", "비밀번호를 확인하세요.");
	        	mav.setViewName("admin/adminLogin/adminLoginForm");
		} else if (result == -1) {
	    		mav.addObject("message", "아이디를 확인하세요.");
	    		mav.setViewName("admin/adminLogin/adminLoginForm");
		}	
		return mav;
	}	
	
	
	@RequestMapping("/adminMain")
	public String adminMain() {
		return "admin/adminLogin/adminMain";
	}
	
	@RequestMapping("/adminLogout")
	public String adminLogout() {
		
		return "redirect:/";
	}
	
	
	//공지사항
	@RequestMapping("/adminNotice")
	public ModelAndView adminNotice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/adminLoginForm");
		else {
			int page = 1;
	        session.setAttribute("page", page);
	        
			HashMap<String, Object> result = as.getNoticeList(request);
			mav.addObject("noticeList", (List<NoticeVO>)result.get("noticeList"));
			mav.addObject("paging", (Paging)result.get("paging"));
			mav.addObject("key", (String)result.get("key"));
			mav.setViewName("admin/adminNotice/adminnotice");
		}
		return mav;
	}
	
	@Autowired
	NoticeService ns;
	
	//공지사항 디테일
	@RequestMapping("adminNoticeDetail")
	public ModelAndView notice_Detail(HttpServletRequest request, 
			@RequestParam("nseq") int nseq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("noticeVO", ns.getNotice(nseq));
		mav.setViewName("admin/adminNotice/adminnoticeDetail");

		return mav;
	}
	
	//공지사항 수정
	@RequestMapping("noticeUpdateForm")
	public String noticeUpdateForm(HttpServletRequest request, Model model,
			@RequestParam("nseq") int nseq) {
		model.addAttribute("noticeVO", ns.viewNotice(nseq));
		return "admin/adminNotice/noticeUpdate";
		
	}
	
	
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(@ModelAttribute("dto") @Valid NoticeVO noticevo,
			BindingResult result, Model model, HttpServletRequest request) {
		String url="admin/adminNotice/noticeUpdate";
		if(result.getFieldError("title")!=null)
			model.addAttribute("message", result.getFieldError("title").getDefaultMessage());
		else if(result.getFieldError("ncontent")!=null)
			model.addAttribute("message", result.getFieldError("ncontent").getDefaultMessage());
		else if(result.getFieldError("id")!=null)
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
		else {
			if(noticevo.getNcontent()==null||noticevo.getNcontent().equals(""))
				noticevo.setNcontent(request.getParameter("oldfilename"));
			as.updateNotice(noticevo);
			url="redirect:/adminNoticeDetail?nseq=" + noticevo.getNseq();
		}
		return url;
	}
	
	// 파일업로드 공지사항
	@RequestMapping(value="fileupno", method=RequestMethod.POST)
	@ResponseBody // 추가해야 원래 페이지로 이동 
	public HashMap<String, Object> fileupno( Model model,
										   HttpServletRequest request 
										  
										 ) {
		String path = context.getRealPath("/images/notice_images"); ; 

		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
				);
			result.put("STATUS", 1);
			result.put("FILENAME", multi.getFilesystemName("fileimage") );		
		}catch (IOException e) {e.printStackTrace();}
		return result;
	}
	
	// 공지사항 추가 
	@RequestMapping("insertnoticeForm")
	public String insertnoticeForm( Model model,
									HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		model.addAttribute("id",id);
		return "admin/adminNotice/insertnoticeForm";
	}
	
	@RequestMapping(value="insertnotice", method = RequestMethod.POST)
	public String insertnotice( @ModelAttribute("dto") @Valid NoticeVO noticevo,
							BindingResult result, 
							Model model
						) {
		
		String url = "admin/adminNotice/insertnoticeForm";
		if(result.getFieldError("title")!=null)
			model.addAttribute("message", result.getFieldError("title").getDefaultMessage());
		else if(result.getFieldError("ncontent")!=null)
			model.addAttribute("message", result.getFieldError("ncontent").getDefaultMessage());
		else if(result.getFieldError("id")!=null)
			model.addAttribute("message", result.getFieldError("id").getDefaultMessage());
		else {
			as.insertNotice( noticevo );
			url ="redirect:/adminNotice";
		}
		return url;
	}

	// 공지사항 삭제
	@RequestMapping("/noticeDelete")
	public String noticeDelete( Model model,
							HttpServletRequest request,
							@RequestParam("nseq") int nseq
			) {
		as.noticeDelete(nseq);
		return "redirect:/adminNotice";
	}
	

	//------------------------------------회원 관리 -------------------------------------- 

	@RequestMapping("/adminMember")
	public ModelAndView adminMember(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/adminLoginForm");
		else {
			int page = 1;
	        session.setAttribute("page", page);
	        
			HashMap<String, Object> result = as.getMeberList ( request );
			mav.addObject("memberList", (List<MemberVO>)result.get("memberList") );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/adminmember/adminMemberList");
		}
		return mav;
	}
	
	
	@RequestMapping("/memberReinsert")
	public  ModelAndView memberReinsert( @RequestParam("id") String id, 
			@RequestParam("useyn") String useyn	,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String workid = (String)session.getAttribute("workId");
		if(workid==null)
			mav.setViewName("redirect:/adminLoginForm");
		else {
			int page = 1;
	        session.setAttribute("page", page);
		System.out.println(id);
		System.out.println(useyn);
		
		if( useyn.equals("Y") ) useyn="N";
		else useyn="Y";
		
		as.memberReinsert( id, useyn );
		
		HashMap<String, Object> result = as.getMeberList ( request );
		mav.addObject("memberList", (List<MemberVO>)result.get("memberList") );
		mav.addObject("paging", (Paging)result.get("paging") );
		mav.addObject("key", (String)result.get("key") );
		mav.setViewName("admin/adminmember/adminMemberList");
		}
		return mav;
	}
	
	
	// ------------------------------------어트랙션 관리 -------------------------------------- 
	
	@RequestMapping("/adminAttraction")
	public ModelAndView adminAttraction(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/adminLoginForm");
		else {
			int page = 1;
	        session.setAttribute("page", page);
	        
	        HashMap<String, Object> result = as.getAttractionList ( request );
			mav.addObject("attractionList", (List<AttractionVO>)result.get("attractionList") );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/adminattraction/adminattraction");
		}
		return mav;
	}
	
	// 파일업로드 어트랙션
	@RequestMapping(value="fileupat", method=RequestMethod.POST)
	@ResponseBody // 추가해야 원래 페이지로 이동 
	public HashMap<String, Object> fileupat( Model model,
										   HttpServletRequest request 
										  
										 ) {
		String path = context.getRealPath("/images/attraction_images"); ; 

		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
				);
			result.put("STATUS", 1);
			result.put("FILENAME", multi.getFilesystemName("fileimage") );		
		}catch (IOException e) {e.printStackTrace();}
		return result;
	}
	
	// 어트래션 추가폼으로 이동
	@RequestMapping("/atInsertForm")
	public String atInsertForm() {
		return "admin/adminattraction/insertAttractionForm";
	}
	
	// 어트랙션 추가 
	@RequestMapping(value="/insertat", method = RequestMethod.POST)
	public String insertat( @ModelAttribute("dto") @Valid AttractionVO attractionvo,
							BindingResult result, 
							Model model
						) {
		
		String url = "admin/adminattraction/insertAttractionFrom";
		if ( result.getFieldError("atname")!= null )
			model.addAttribute("message", result.getFieldError("atname").getDefaultMessage() );
		else if ( result.getFieldError("acontent")!= null )
			model.addAttribute("message", result.getFieldError("acontent").getDefaultMessage() );
		else if ( result.getFieldError("act1")!= null )
			model.addAttribute("message", result.getFieldError("act1").getDefaultMessage() );
		else if ( result.getFieldError("act2")!= null )
			model.addAttribute("message", result.getFieldError("act2").getDefaultMessage() );
		else if ( result.getFieldError("image")!= null )
			model.addAttribute("message", result.getFieldError("image").getDefaultMessage() );
		else if ( result.getFieldError("limitkey")!= null )
			model.addAttribute("message", result.getFieldError("limitkey").getDefaultMessage() );
		else if ( result.getFieldError("limitage")!= null )
			model.addAttribute("message", result.getFieldError("limitage").getDefaultMessage() );
		else if ( result.getFieldError("bestat")!= null )
			model.addAttribute("message", result.getFieldError("bestat").getDefaultMessage() );
		else if ( result.getFieldError("aresult")!= null )
			model.addAttribute("message", result.getFieldError("aresult").getDefaultMessage() );
		else {
			as.insertat( attractionvo );
			url ="redirect:/adminAttraction";
		}
		return url;
	}
	
	// atView
	@Autowired 
	AttractionService ats;
	
	@RequestMapping("/adminattractionDetail")
	public ModelAndView adminattractionDetail (@RequestParam("aseq") int aseq
									) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("AttractionVO", ats.getAttraction(aseq) );
		mav.setViewName("admin/adminattraction/adminattractionDetail");
		return mav;
	}
	
	// at 업뎃 폼
	@RequestMapping("adminUpdateAttractionForm")
	public String adminUpdateAttractionForm(
								@RequestParam("aseq") int aseq,
								HttpServletRequest request,
								Model model
			) {
		model.addAttribute("AttractionVO", ats.getAttraction(aseq) );
		return "admin/adminattraction/AttractionUpdate";
	}
	// at 업뎃 
	@RequestMapping(value = "updateat", method = RequestMethod.POST)
	public String updateat(
			@ModelAttribute("dto") @Valid AttractionVO attractionvo, 
			BindingResult result, Model model, HttpServletRequest request
			
			) {
		
		String url = "admin/adminattraction/AttractionUpdate" ;
		if ( result.getFieldError("atname")!= null )
			model.addAttribute("message", result.getFieldError("atname").getDefaultMessage() );
		else if ( result.getFieldError("acontent")!= null )
			model.addAttribute("message", result.getFieldError("acontent").getDefaultMessage() );
		else if ( result.getFieldError("act1")!= null )
			model.addAttribute("message", result.getFieldError("act1").getDefaultMessage() );
		else if ( result.getFieldError("act2")!= null )
			model.addAttribute("message", result.getFieldError("act2").getDefaultMessage() );
		else if ( result.getFieldError("limitkey")!= null )
			model.addAttribute("message", result.getFieldError("limitkey").getDefaultMessage() );
		else if ( result.getFieldError("limitage")!= null )
			model.addAttribute("message", result.getFieldError("limitage").getDefaultMessage() );
		else if ( result.getFieldError("bestat")!= null )
			model.addAttribute("message", result.getFieldError("bestat").getDefaultMessage() );
		else if ( result.getFieldError("aresult")!= null )
			model.addAttribute("message", result.getFieldError("aresult").getDefaultMessage() );
		else {
			if ( attractionvo.getImage() ==null || attractionvo.getImage().equals("") )
				attractionvo.setImage( request.getParameter("oldImage") );
			as.updateat ( attractionvo );
			url = "redirect:adminattractionDetail?aseq=" + attractionvo.getAseq() ;
		}
		return url;
	}
		
	// 삭제
	@RequestMapping("/deleteat")
	public String deleteat( Model model,
							HttpServletRequest request,
							@RequestParam("aseq") int aseq
			) {
		as.deleteat(aseq);
		return "redirect:/adminAttraction";
	}
	
	//------------------------------------Q&A 관리 -------------------------------------- 
	@RequestMapping("/adminQna")
	public ModelAndView adminQna( HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("workId");
		if(id==null)
			mav.setViewName("redirect:/adminLoginForm");
		else {
			int page = 1;
	        session.setAttribute("page", page);
	        
			HashMap<String, Object> result = as.getQnaList ( request );
			mav.addObject("qnaList", (List<QnaVO>)result.get("qnaList") );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("admin/adminQna/adminQnaList");
		}
		return mav;
	}
	
	// qnaview
	@Autowired 
	QnaService qs;
	
	@RequestMapping("/adminQnaView")
	public ModelAndView adminQnaView (@RequestParam("lqseq") int lqseq
									) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("qnaVO", qs.getQna(lqseq) );
		mav.setViewName("admin/adminQna/adminQnaView");
		return mav;
	}
	
	// 답글 추가 
	@RequestMapping(value="/adminQnaRepSave", method =RequestMethod.POST)
	public String adminQnaRepSave ( @RequestParam("lqseq") int lqseq,
									@RequestParam("reply") String reply
								  ) {		
	
		as.updateQna( lqseq, reply);
		return "redirect:/adminQnaView?lqseq=" + lqseq ;
	}

	
	// ------------------------------------배너 관리 -------------------------------------- 
	
	// 배너 리스트로 이동
	@RequestMapping("/adminBannerList")
	public ModelAndView adminBannerList( ) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("bannerList", as.getBannerList() );
		mav.setViewName("admin/Banner/bannerList");
		return mav;
	}
	
	// 배너등록으로 이동 
	@RequestMapping("/newBannerWrite")
	public String newBannerWrite() {
		return "admin/Banner/writeBanner";
	}
	

	// 파일 업로드 배너

	@RequestMapping(value="fileupba", method=RequestMethod.POST)
	@ResponseBody // 추가해야 원래 페이지로 이동 
	public HashMap<String, Object> fileupba( Model model,
										   HttpServletRequest request 
										  
										 ) {
		String path = context.getRealPath("/images/banner"); ; 
		/*
		  switch( kind ) { 
		  	case "attraction" : 
		  		path = context.getRealPath("/images/attraction_images"); 
		  	break; 
		  	case "banner" : 
		  		path = context.getRealPath("/images/banner"); 
		  	break; 
		  	case "notice" : 
		  		path = context.getRealPath("/images/notice_images"); 
		  		break; 
		  }
		 /*
		  if (kind.equals( "attraction" )) {
		        path = context.getRealPath("/images/attraction_images");
		    } else if (kind.equals("banner")) {
		        path = context.getRealPath("/images/banner");
		    } else if (kind.equals("notice")) {
		        path = context.getRealPath("/images/notice_images");
		    }
		  */ 
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
				);
			result.put("STATUS", 1);
			result.put("FILENAME", multi.getFilesystemName("fileimage") );		
		}catch (IOException e) {e.printStackTrace();}
		return result;
	}
	
	
	// 배너 등록 
	@RequestMapping(value="/bannerWrite" )
	public String bannerWrite(  BannerVO bannervo	) {
		if( bannervo.getOrder_seq() == 9 ) 
			bannervo.setUseyn("N");
		else bannervo.setUseyn("Y");
		as.insertBanner( bannervo );
		return "redirect:/adminBannerList";
	}
	
	// 배너 순서 변경
	@RequestMapping("/change_order")
	public String change_order(
			HttpServletRequest request,
			@RequestParam("bseq") int bseq,
			@RequestParam("changeval") int changeval 
			) {
		String useyn;
		if( changeval > 8 ) useyn="N";
		else useyn="Y";
		as.updateSeq( changeval, useyn, bseq);
		return"redirect:/adminBannerList";
	}
	
	// 배너 삭제
	@RequestMapping ("/deleteBanner")
	public String deleteBanner ( @RequestParam ("bseq") int bseq,
								 Model model
			) {
	as.deleteBanner( bseq );
	return "redirect:/adminBannerList";
		
	}
	
	//--------------------------------
	@RequestMapping ("/adminOrderList")
	public ModelAndView adminOrderList(
			@RequestParam ("id") String id,
			@RequestParam ("name") String name
			) {
		
		ModelAndView mav =new ModelAndView();
		List<Cart2VO> cvo =  as.getAdminOrderList( id );
		mav.addObject("orderList",  cvo  );
		mav.addObject("id",  id  );
		mav.addObject("name",  name  );
		mav.setViewName("admin/adminmember/adminOrderList");
		
		return mav;
	}
	
	
	
	@Autowired
	TicketService ts;
	
	@RequestMapping(value = "/adminRefund", method = RequestMethod.POST)
	public ModelAndView adminRefund(HttpServletRequest request,
			@RequestParam ("id") String id,
			@RequestParam ("name") String name) {
		
		String[] cseqArr =request.getParameterValues("cseq");
		for( String cseq : cseqArr)
			ts.deleteCart(Integer.parseInt(cseq));
		ModelAndView mav =new ModelAndView();
		List<Cart2VO> cvo =  as.getAdminOrderList( id );
		mav.addObject("orderList",  cvo  );
		
		mav.addObject("name",  name  );
		mav.setViewName("admin/adminmember/adminOrderList");
		
		return mav;
	
	}
		
}

