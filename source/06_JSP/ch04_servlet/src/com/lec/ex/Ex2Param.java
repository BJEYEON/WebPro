package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class Ex2Param
 */
@WebServlet("/Ex2")
public class Ex2Param extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex2Param() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //파라미터 한글처리
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//menu, rest, nation 파라미터 전달받아 화면에 출력
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		//String rest = request.getParameter("rest");//x
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(menu!=null) {
			//out.println("<h2>선택한 메뉴는" + Arrays.toString(menu) + "</h2>");
			out.println("<h2>선택한 메뉴는");
			for (String m: menu) {
				out.print(m + ", ");
			}
			for(int i=0; i<menu.length; i++) {
				if(i==menu.length-1) {
					out.print(menu[i]);
				}else {
					out.print(menu[i] + ", w");
				}
			}
			out.println("입니다</h>");
		}else {
			out.println("<h2>선택한 메뉴가 없습니다</h2>");
		}
		if(rest!=null) {
			out.println("<h2>선택한 식당은" + Arrays.toString(rest) + "</h2>");
		}else {
			out.println("<h2>선택한 식당이 없습니다</h2>");
		}
//		out.println("<h2>선택한 메뉴는" + menu + "</h2>");
//		out.println("<h2>선택한 식당은" + rest + "</h2>");
		out.println("<h2>선택한 국적는" + nation + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
