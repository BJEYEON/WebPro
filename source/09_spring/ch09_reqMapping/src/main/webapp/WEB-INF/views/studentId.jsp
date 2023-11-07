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
	<h3>studentId.jsp페이지입니다</h3>
	<h4>전송방식 : ${method }</h4>
	<h4>model의id : ${id }</h4>
	<h4>파라미터로 온 id : ${param.id }</h4>
</body>
</html>