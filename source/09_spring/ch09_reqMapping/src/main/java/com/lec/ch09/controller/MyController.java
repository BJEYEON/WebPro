package com.lec.ch09.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	@RequestMapping(value="main", method=RequestMethod.GET) //main.do요청
	public String main() {
		return "main";
	}
//	@RequestMapping(value="student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod(); //get또는post
//		logger.info("들어온 요청방식은" + method);
//		model.addAttribute("method", "post");
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String student(String id, Model model) {
		logger.info("들어온 요청방식은GET");
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value="student", method=RequestMethod.POST)
	public String student(Model model, String id) {
		logger.info("들어온 요청방식은POST");
		model.addAttribute("method", "POST");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value="studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentOk", method=RequestMethod.POST)
	public String studentOkPost() {
		return "studentOk";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.POST)
	public ModelAndView studentNg(ModelAndView mav) {
		mav.setViewName("studentNg");
		return mav;
	}
	@RequestMapping(value="idConfirm.do", method=RequestMethod.POST)
	public String idConfirm(String id, Model model) { //id를 받으니
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			//제대로된id를 입력한 경우 "studentOk.do" 요청
			//return "redirect:studentOk.do"; //새로운request객체로studentOk.do요청(get)
			return "forward:studentOk.do"; //request객체를 새로 생성하지 않고, studentOk.do요청
			//forward는 post로감
		}else {
			// confirm실패된 id를 입력한 경우 "studentNg.do"요청
			//return "redirect:studentNg.do"; //새로운request객체로 studentNg.do요청
			return "forward:studentNg.do";
		}
	}
	@RequestMapping(value="fullPath", method=RequestMethod.GET)
	public String fullPath() {
		//return "redirect:http://www.naver.com";
		return "redirect:temp/temp.jsp";
	}
}
