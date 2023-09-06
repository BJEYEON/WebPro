package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Ex1", urlPatterns = { "/Ex1" })
public class Ex1_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex1_Test() {
        super();
    }
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service()수행get,post수행x");
//		request.setCharacterEncoding("utf-8"); //파라미터 한글처리
//	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()수행");
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()수행");
		request.setCharacterEncoding("utf-8"); //파라미터 한글처리
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>이름은" + name + "</h2>");
		out.println("<h2>비번은" + pw + "</h2>");
		out.println("<h3>요청방식은" + request.getMethod() + "</h3>");
		out.println("</body>");
		out.println("</html>");
	}

}
