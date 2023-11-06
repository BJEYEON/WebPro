package com.lec.ch07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch07.dto.Member;
//member?method=join	member?method=login
//member?method=logout	member?method=modify
@Controller
@RequestMapping("member") //공통요청경로
public class MemberController {
	@RequestMapping(params = "method=join", method=RequestMethod.GET) //member?method=join
	public String join(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	@RequestMapping(params = "method=join", method=RequestMethod.POST)
	public ModelAndView join1(ModelAndView mav) {
		mav.addObject("kind", "회원가입(완료)");
		mav.setViewName("member/result");
		return mav;
	}
	@RequestMapping(params = "method=login", method=RequestMethod.GET)
		public String login(Model model) {
			model.addAttribute("kind", "로그인");
			return "member/result";
		}
	@RequestMapping(params = "method=logout", method=RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("kind", "로그아웃");
		return "member/result";
	}
	@RequestMapping(params = "method=modify", method=RequestMethod.GET)
	public String modifyView(Model model) {
		model.addAttribute("member", new Member("aaa", "111"));
		return "member/modify";
	}
	@RequestMapping(params = "method=modify", method=RequestMethod.POST)
	public String modify(Model model) {
		model.addAttribute("kind", "member modify post수정완료");
		return "member/result";
	}
}
