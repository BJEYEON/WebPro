<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--지시자(<%@ %> : page, include, taglib(사용자태그사용;16장) --%>
	<%
		int[] arr = {10,20,30};
		out.println(Arrays.toString(arr));
	%>
	<%@ include file="../main/footer.jsp" %>
	<hr>
	<%@ include file="ex2_선언부_표현식.jsp" %>
	<hr>
	다시 ex_지시자.jsp페이지입니다
	
	
</body>
</html>