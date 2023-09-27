<%@page import="com.lec.ex.Member"%>
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
	<% //자바에서 구현될 소스
		Member member = new Member("aaa", "aaa", "홍길동");
		request.setAttribute("member", member);
	%>
	<h1>회원정보 (el표기법)</h1>
	<h3>member : ${member }</h3>
	<%-- <h3>ID : <%=((Member)request.getAttribute("member").getId()); %></h3> --%>
	<h3>id : ${member.id }</h3> <!-- getId -->
	<h3>pw : ${member.pw }</h3>
	<h3>pw : ${member.name }</h3>
</body>
</html>