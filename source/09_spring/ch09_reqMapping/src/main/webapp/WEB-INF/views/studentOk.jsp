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
	<h2>studentOk페이지입니다</h2>
	<h4>
		Model(confirm된) id : 
		<c:if test="${empty id }">
			x (model의id가 없음.바로실행 . redirect키워드를 사용)
		</c:if>
		<c:if test="${not empty id }">
			${id }(model의id가 있음. forward 키워드를 사용)
		</c:if>
	</h4>
	<h4>
		파라미터로 넘어온id
		<c:if test="${empty param.id }">
			x (바로실행 redirect키워드를 사용)
		</c:if>
		<c:if test="${not empty param.id }">
			${param.id }(파라미터 id가 남아있음.바로실행,forward키워드를 사용)
		</c:if>
	</h4>
</body>
</html>