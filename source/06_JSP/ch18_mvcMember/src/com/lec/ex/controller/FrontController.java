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
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청에 따른 service를 호출 하고 뷰단으로 forward
		String uri = request.getRequestURI(); // "/ch18_mvcMmeber/main.do"
		String conPath = request.getContextPath(); // "/ch18_mvcMember" (15글자)
		String command = uri.substring(conPath.length()); //"/main.do"; 들어온 요청
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) { //메인페이지로
			viewPage = "member/main.jsp";
		}else if(command.equals("/loginView.do")) { //로그인 화면
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) { //db를 통해 로그인 확인 및 세션 처리
			service = new MloginService();
			service.execute(request, response);
			// next파라미터 값에 따른forward
			String next = request.getParameter("next");
			if(next==null || next.equals("")) {
				viewPage = "member/main.jsp";
			}else {
				viewPage = next;
			}
		}else if(command.equals("/joinView.do")) { //회원가입 화면
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) { //회원가입db처리후 로그인으로 가고 id엔 가입한 id가 출력
			service = new MjoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(command.equals("/logout.do")) { //로그아웃- 세션날리기
			service = new MlogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/modifyView.do")) { //정보 수정 화면
//			service = new MgetMemberService(); - 세션의 member값으로 대체 
//			service.execute(request, response); - 이건db에있는값
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) { //정보수정db처리후 세션도 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/allView.do")) { //전체 회원리스트
			
		}else if(command.equals("/withdrawal.do")) { //회원탈퇴
			
		}
		//view로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
