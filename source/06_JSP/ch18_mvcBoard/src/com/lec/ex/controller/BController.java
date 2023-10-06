package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.*;
@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int writeMode = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 들어온 요청에 따른 일을 하고 뷰단으로forward
		String uri = request.getRequestURI(); //"/ch18_mvcBoard/list.do"
		String conPath = request.getContextPath(); //"/ch18_mvcBoard"
		String command = uri.substring(conPath.length()); //"/list.do"
		String viewPage = null;
		Service service = null;
		if(command.equals("/list.do")) { //글목록 list.do?pageNum=2
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.equals("/writeView.do")) { //글쓰기 form태그 페이지(뷰단
			viewPage = "board/write.jsp";
			writeMode = 1;
		}else if(command.equals("/write.do")) { //글쓰기db에 저장
			if(writeMode == 1) {
				service = new BWriteService();
				service.execute(request, response);//db저장
				writeMode = 0;
			}
			viewPage = "list.do";
		}else if(command.equals("/content.do")) {//상세보기
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content.jsp";
		}else if(command.equals("/updateView.do")) { // 글수정을 위한view
			service = new BModifyViewService();
			service.execute(request, response); //request에modifyBoard추가
			viewPage = "board/modify.jsp";
		}else if(command.equals("/update.do")) {// db에 글수정
			service = new BModifyService();
			service.execute(request, response);//request에modifyBoard추가
			//viewPage = "list.do"; //requestScope.modifyRsult, param.bid, param.bname, param.등등
			viewPage = "content.do?after=u"; //수정 후 상세보기 페이지로 넘어갈때 hit수 증가안함
		}else if(command.equals("/delete.do")) { //db에 글삭제
			service = new BDeleteService();
			service.execute(request, response); // request에 deleteMsg추가
			viewPage = "list.do"; //param.pageNum
		}else if(command.equals("/replyView.do")) { //답변글 쓰기 form태그 페이지 뷰단
			service = new BReplyViewService();
			service.execute(request, response); // request에replyBoard추가
			viewPage = "board/reply.jsp";
		}else if(command.equals("/reply.do")) { //db에 답변글 저장
			service = new BReplyService();
			service.execute(request, response); //request에 replyResult추가
			viewPage = "list.do"; //param.pageNum, param.bid
		}
		//뷰단으로 foward
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);//viewPage로 가자
		dispatcher.forward(request, response);
	}

}
