<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h3>board의reply.jsp입니다</h3>
	<h4>${member.id } / ${member.pw }</h4>
	<form action="${conPath }/board/reply" method="post">
		<input type="submit" value="reply(POST)">
	</form>
	<hr>
	<h4 onclick="history.back()">이전페이지로 가기</h4>
</body>
</html>