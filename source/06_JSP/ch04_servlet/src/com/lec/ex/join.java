package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
		doGet(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stubString hiddenParam = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth"); // 파라미터 값은 무조건 문자열 전달
		Date birthDate = null;    // 날짜만 필요한 경우
		Timestamp birthTS = null; // 날짜, 시간이 다 필요한 경우
		if(birth!=null && !birth.equals("") ) {
			birthDate = Date.valueOf(birth);
			birthTS = Timestamp.valueOf(birth + " 00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/join.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id='join_title'>회원가입정보</div>");
		out.println("<h2>이름 : " + name + "</h2>");
		out.println("<h2>아이디 : " + id + "</h2>");
//		out.println("<h2>비번 : ");
//		for(int i=0 ; i<pw.length() ; i++) {
//			out.print("*");
//		}
//		out.println("</h2>");
		out.println("<h2>비번 : " + pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\\\{}\\[\\]:;\"'?/<>,\\.]", "*") + "</h2>");
		out.println("<h2>생년월일(String) : "+(birth.equals("")? "-":birth)+"</h2>");
		out.println("<h2>생년월일(Date) : " + (birthDate==null ? "-":birthDate) +"</h2>");
		out.println("<h2>생년월일(TS) : " + (birthTS==null ? "-":birthTS) +"</h2>");
		out.println("<h2>취미 : ");
		if(hobby!=null) {
			for(int i=0 ; i<hobby.length ; i++)
				if(i==hobby.length-1)
					out.print(hobby[i]);
				else
					out.print(hobby[i]+", ");
		}else {
			out.print("없음");
		}
		out.println("</h2>");
		out.println("<h2>성별 : "+gender+"</h2>");
		out.println("<h2>이메일 : "+(email.equals("") ? "-":email)+"</h2>");
		out.println("<h2>메일수신동의 : ");
		if(mailSend!=null) {
			out.print(Arrays.toString(mailSend));
		}else {
			out.print("모두 거부");
		}
		out.println("</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
