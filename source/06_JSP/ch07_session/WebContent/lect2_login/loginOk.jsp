<%@page import="com.lec.ex.Member"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		//id, pw 파라미터로 받고 유효한 id와pw인 경우-> 로그인 처리(세션에 추가) -> welcome,jsp/ login.jsp
		//					유효하지 않은id나pw인경우 :login.jsp?msg=~check
		//request.setCharacterEncoding("utf-8");
		String msg ="";
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa")){
			//유효한id를 입력한 경우
			if(pw!=null && pw.equals("111")){
				// 유효한 pw를 입력한 경우 로그인처리(세션에 속성추가)
				session.setAttribute("id", id);
				session.setAttribute("name", "홍길동");
				/* Member member = new Member(id, pw, "홍길동");
				session.setAttribute("member", "member"); */
				response.sendRedirect("welcome.jsp");
				
				
			}else{
				// pw를 틀린경우
				msg = URLEncoder.encode("pw를 체크하세요", "utf-8");
				response.sendRedirect("login.jsp?msg=" + msg);
				
			}
		}else{
			//유효하지 않은id를 입력한경우
			msg = URLEncoder.encode("id를 체크하세요", "utf-8");
			response.sendRedirect(conPath + "/lect2_login/login.jsp?msg="+msg);
		}
	%>
</body>
</html>