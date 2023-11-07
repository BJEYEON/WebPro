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
	<h5>어떤요청이 들어와도cnt, list는model에 addehla</h5>
	<h4>cnt : ${cnt }</h4>
	<h4>list: ${list }</h4>
	<h2>result4.jsp페이지입니다(join4)</h2>
	<h4>이름: ${member.name }</h4>
	<h4>아이디: ${member.id }</h4>
	<h4>비밀번호: ${member.pw }</h4>
	<h4>나이: ${member.age }</h4>
	<h4>메일: ${member.email }</h4>
	<h4>주소: ${member.address }</h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conpath}'">홈으로</button>
</body>
</html>