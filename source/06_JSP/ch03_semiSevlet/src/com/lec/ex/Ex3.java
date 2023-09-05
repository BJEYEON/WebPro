package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex3() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_num = request.getParameter("num");
		String str_Gugu="";
		response.setContentType("text/html; charset=UTF-8"); //깨진한글변환
		int num = Integer.parseInt(str_num);
		PrintWriter out = response.getWriter();
		for(int i=1; i<10; i++) {
			str_Gugu += (num + "*" + i + "=" + (num*i) + "\r\n");
		}
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<caption>" + num +"단</caption>");
		out.println("<tr>");
		out.println("<td>" + str_Gugu + "</td>");
		
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
