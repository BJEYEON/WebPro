<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="join.css" rel="stylesheet" type="text/css">
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
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
	String ip = request.getRemoteAddr(); //요청한 클라이언트의 ip주소
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String[] mailSend = request.getParameterValues("mailSend");
	
	
%>
<div id='joinForm_wrap'>
	<div id='join_title'>회원가입정보</div>
		<h2>이름 : <%=name %></h2>
		<h2>아이디 : <%=id %></h2>
		<h2>비번 : <%= pw.replaceAll("[a-zA-Z0-9~`!@#$%^&*()\\-_+=|\\\\{}\\[\\]:;\"'?/<>,\\.]", "*")%></h2>
		<h2>생년월일(String) : <%= (birth.equals("")? "-":birth)%></h2>
		<h2>생년월일(Date) : <%= (birthDate==null ? "-":birthDate)%></h2>
		<h2>생년월일(TS) : <%= (birthTS==null ? "-":birthTS)%></h2>
		<h2>취미 : <% if(hobby!=null) {
			for(int i=0 ; i<hobby.length ; i++)
				if(i==hobby.length-1)
					out.print(hobby[i]);
				else
					out.print(hobby[i]+", ");
		}else {
			out.print("없음");
		}%></h2>
		<h2>성별 : <%= gender%></h2>
		<h2>이메일 : <%= (email.equals("") ? "-":email)%></h2>
		<h2>메일수신동의 : <%= (mailSend!=null)? Arrays.toString(mailSend):"모두 거부" %></h2>
		<h2>가입ip: <%=ip %></h2>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>