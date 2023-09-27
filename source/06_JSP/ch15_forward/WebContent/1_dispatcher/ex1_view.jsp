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
	<h1>회원정보(ex1_view.jsp페이지입니다)</h1>
	<h3>회원${member }</h3>
	<h3>id: ${member.id }</h3>
	<h3>pw: ${member.pw }</h3>
	<h3>name: ${member.name }</h3>
</body>
</html>