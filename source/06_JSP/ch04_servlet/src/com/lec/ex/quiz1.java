package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz1")
public class quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //파라미터 한글처리
		actionDo(request, response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String[] gugu = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		if(gugu!=null) {
			for(int i=0; i<gugu.length; i++) {
				int int_gugu =Integer.parseInt(gugu[i]);
				out.println("<h2>" + gugu[i] + "단");
				for (int q=1; q<=9; q++) {
					out.printf("%d * %d = %d <br>", gugu[i], q, int_gugu*q);
				}
			}
		}else {
			out.println("<h4>선택된 구구단이 없습니다</h4>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
