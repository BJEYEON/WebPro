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
	<h4>어떤 요청이 들어오든 cnt, list는model에 add됨</h4>
	<h6>cnt : ${cnt }</h6>
	<h6>list : ${list }</h6>
	<h6>id : ${id }</h6>
</body>
</html>