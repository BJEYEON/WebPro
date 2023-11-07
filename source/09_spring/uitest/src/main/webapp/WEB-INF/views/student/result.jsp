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
	<p class="num">현재총 ${num }명</p>
	<h2>결과는 다음과 같습니다.</h2>
	
	<h4>이름: ${student.name }</h4>
	<h4>국어: ${student.kor }</h4>
	<h4>영어: ${student.eng }</h4>
	<h4>수학: ${student.math }</h4>
	<h4>총점: ${student.tot }</h4>
	<h4>평균: ${student.tot/3.0 }</h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conpath}'">홈으로</button>
</body>
</html>