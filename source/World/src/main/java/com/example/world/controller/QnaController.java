package com.example.world.controller;

import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.example.world.dto.MemberVO;
import com.example.world.dto.Paging;
import com.example.world.dto.QnaVO;
import com.example.world.service.QnaService;




@Controller
public class QnaController {

	@Autowired
	QnaService qs;
	
	@RequestMapping("/qna")
	public String qna() {
		return "qna/qna";
	}
	
	@RequestMapping("/qnaList")
	public ModelAndView qnaList( HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		
			HashMap<String, Object> result =  qs.qnaList( request );
			mav.addObject("qnaList",  (List<QnaVO>)result.get("qnaList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("qna/qnaList");

		return mav;
	}
	
	@RequestMapping("/qnaView")
	public ModelAndView qna_view( HttpServletRequest request, @RequestParam("lqseq") int lqseq) {
	    ModelAndView mav = new ModelAndView();
		mav.addObject("qnaVO", qs.getQna(lqseq) );
		mav.setViewName("qna/qnaView");
		return mav;
	}

	@RequestMapping("/passCheck")
	public ModelAndView passCheck( @RequestParam("lqseq") int lqseq ) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("lqseq", lqseq);
		mav.setViewName("qna/checkPass");
		return mav;
	}
	
	@RequestMapping(value="/qnaCheckPass", method=RequestMethod.POST)
	public String qnaCheckPass( 
			@RequestParam("lqseq") int lqseq, 
			@RequestParam("pass") String pass, 
			Model model ) {

		QnaVO qvo = qs.getQna(lqseq);
		model.addAttribute("lqseq" , lqseq);
		
		if( qvo.getPass().equals(pass) ) {
			return "qna/checkPassSuccess";
		}else {
			model.addAttribute("message", "비밀번호가 맞지 않습니다");
			return "qna/checkPass";
		}
			
	}
	
	@RequestMapping("/qnaWriteForm")
	public String qna_writre_form(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
	    MemberVO mvo= (MemberVO) session.getAttribute("loginUser");    	    
	    if (mvo == null) return "member/login";
	    
	    return "qna/qnaWrite";
	}
	
	@RequestMapping(value="/qnaWrite", method=RequestMethod.POST)
	public ModelAndView qna_write(
						@ModelAttribute("dto") @Valid QnaVO qnavo,
						@RequestParam(value="pass", required=false) String pass,
						@RequestParam(value="check", required=false) String check,
						BindingResult result,  HttpServletRequest request	) {
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if( mvo == null ) {
			mav.setViewName("member/login");
		}else {
			
			if(result.getFieldError("title") != null ) 
	    		mav.addObject("message", result.getFieldError("title").getDefaultMessage() );
	    	else if(result.getFieldError("content") != null )
	    		mav.addObject("message", result.getFieldError("content").getDefaultMessage());
	    	else {
	    		if( check == null ) {
	    			qnavo.setPasscheck( "N" );
	    			qnavo.setPass("");
	    		}else {
	    			qnavo.setPasscheck( "Y" );
	    			qnavo.setPass(pass);
	    		}
	    		qnavo.setId( mvo.getId() );
	    		qs.insertQna( qnavo );
	    		mav.setViewName("redirect:/qnaList");
	    	}
		}
		return mav;
	}
	
	//모바일-------------------------------------------------------------------------------------------
	
	@RequestMapping("/mobileQna")
	public String mobileQna() {
		return "mobile/mobileQna/mobileQna";
	}
	
	@RequestMapping("/mobileQnaList")
	public ModelAndView mobileQnaList( HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		
			HashMap<String, Object> result =  qs.qnaList( request );
			mav.addObject("qnaList",  (List<QnaVO>)result.get("qnaList")  );
			mav.addObject("paging", (Paging)result.get("paging") );
			mav.addObject("key", (String)result.get("key") );
			mav.setViewName("mobile/mobileQna/mobileQnaList");

		return mav;
	}
	
	
}
