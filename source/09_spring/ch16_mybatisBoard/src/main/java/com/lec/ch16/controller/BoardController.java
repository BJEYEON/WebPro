package com.lec.ch16.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch16.service.BoardService;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST}) //뷰단 클래스이름 value=""
	public String list(String pageNum, Model model) {
		Paging paging =  new Paging(boardService.getBoardTotCnt(), pageNum, 10, 10);
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardService.boardList(paging));//페이징한 보드리스트 보드서비스에서 가져와서list.jsp에있는boardList로
		return "board/list"; //list.jsp로
	}
	@RequestMapping(value="dummyData70insert", method=RequestMethod.GET)
	public String dummyData70Write() {
		boardService.dummyData70Write();
		return "redirect:board/list.do";
	}
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String writeView() {
		return "board/write";
	}
	@RequestMapping(value="write", method= RequestMethod.POST)
	public String write(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("writeResult", boardService.boardWrite(board, request));
		return "forward:list.do";
	}
	@RequestMapping(value="content", method= {RequestMethod.GET, RequestMethod.POST})
	public String content(int bid, String after, Model model) {
		model.addAttribute("contentBoard", boardService.boardContent(bid, after));
		return "board/content";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("board",boardService.boardModifyReplyView(bid));
		return "board/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("board", boardService.boardModify(board, request));
		return "forward:content.do?after=u";
	}
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value="reply", method = RequestMethod.GET) //원글을 보여주는 페이지
	public String reply(int bid, Model model) {
		model.addAttribute("board", boardService.boardModifyReplyView(bid)); // BoardServiceImpl 에boardModifyReplyView  board는reply에있는board가져오는거
		return "board/reply"; 
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(Board board, HttpServletRequest request, Model model) {
		model.addAttribute("replyResult", boardService.boardReply(board, request)); //위에서 가져온거 jsp에있는reply replyResult로 뿌림
		return "forward:list.do";
		
	}
}
