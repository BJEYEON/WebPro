package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empSch")
public class EmpSch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// schname과 schjob파라미터받아dao.getListEmp(schname, schjob)결과를 resuest추가
		String schName = request.getParameter("schName");
		String schJob = request.getParameter("schJob");
		EmpDao dao = EmpDao.getInstance();
		ArrayList<EmpDto> emps = dao.getlistSch(schName, schJob);
		request.setAttribute("emps", emps);
		//뷰단으로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_emp/empSch.jsp");
		dispatcher.forward(request, response);
		
	}

}
