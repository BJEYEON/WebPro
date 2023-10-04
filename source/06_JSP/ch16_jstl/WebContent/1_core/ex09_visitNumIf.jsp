<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="visitNum" value="${param.visitNum }"/>
	<c:if test="${visitNum eq 1 }">
		<h2>첫방문 감사합니다</h2>
	</c:if>
	<c:if test="${visitNum > 1 && visitNum < 6 }">
		<h2>많이 많이 방문해 주세요</h2>
	</c:if>
	<c:if test="${visitNum >= 6 }">
		<h2>많이 많이 방문해 주셔서 감사합니다</h2>
	</c:if>
	<c:if test="${empty visitNum || visitNum<=0 }">
		<h2>제대로된 방문횟수를 받지 못했습니다</h2>
	</c:if>
</body>
</html>