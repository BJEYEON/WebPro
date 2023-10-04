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
	<h2>예외처리 태그</h2>
	<c:catch var="e"> <!-- c:catch절에서 예외가 발생할 경우, 예외객체가 e변수 할당되고 c:catch절을 빠져나감 -->
		<h2>테스트</h2>
		${8/0 }
		<%=8/0 %>
		<p>예외가 발생되는 즉시 c:catch절을 빠져나감. 이 p 태그 출력시 예외가 발생 안된 것임
	</c:catch>
	예외타입과 예외매세제 : <c:out value="${e }" default="예외 발생 안됨"/>
</body>
</html>