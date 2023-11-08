package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.service.BContentService;
import com.lec.ch11.service.BDeleteService;
import com.lec.ch11.service.BListServie;
import com.lec.ch11.service.BModifyReplyViewService;
import com.lec.ch11.service.BModifyService;
import com.lec.ch11.service.BReplyService;
import com.lec.ch11.service.BService;
import com.lec.ch11.service.BWriteService;
import com.lec.ch11.vo.BoardDto;
// board/list.do, board/write.do, board/content.do, /board/modify.do
@Controller
@RequestMapping("board") //공통요청경로
public class BoardController {
	@Autowired
	private BListServie bListService;
	@Autowired
	private BWriteService bWriteService;
	@Autowired
	private BContentService bContentService;
	@Autowired
	private BModifyReplyViewService bModifyReplyViewService;
	@Autowired
	private BModifyService bModifyService;
	@Autowired
	private BDeleteService bDeleteService;
	@Autowired
	private BReplyService bReplyService;
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(String pageNum, Model model) {
		// board/list.do?pageNum=10
		//board/list.do
		model.addAttribute("pageNum", pageNum); //서비스에 전달하기위해 2거나10null..
		//service = new BListServie(); 의존관계 객체를 주입받음
		bListService.execute(model);
		return "board/list";
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute("bDto") BoardDto boardDto, //@ModelAttribute("bDto")이름바꾸기
			HttpServletRequest request,
			Model model //service의excute실행 시 매개변수로 전달용
			) {
		//request를 service에 전달
		model.addAttribute("request", request);
		//service = new BWriteService(); 안함
		bWriteService.execute(model);
		return "forward:list.do";
	}
	//content.do?bid=4&pageNum=1 (list.jsp에서)
	// content.do?bid=4&pageNum=1after=u (수정완료후)
	@RequestMapping(value="content", method= {RequestMethod.GET, RequestMethod.POST})
	public String content(int bid, String after, Model model) {
		model.addAttribute("bid", bid);
		model.addAttribute("after", after);
		bContentService.execute(model);
		//서비스 함수 호출
		return "board/content";
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modify(int bid, Model model) {
		model.addAttribute("bid", bid);
		//서비스 함수 호출
		bModifyReplyViewService.execute(model);
		return "board/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(BoardDto boardDto, Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		bModifyService.execute(model);
		return "forward:content.do?after=u";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		//서비스함수호출
		bDeleteService.execute(model);
		return "forward:list.do";
	}@RequestMapping(value="reply", method=RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("bid", bid);
		bModifyReplyViewService.execute(model);
		return "board/reply";
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(BoardDto boardDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		//서비스함수 호출
		bReplyService.execute(model);
		return "forward:list.do";
	}
}
