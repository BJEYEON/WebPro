<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%// main.jsp -> main.jsp?pageNum=1  main.jsp?pageNum=2
			
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>