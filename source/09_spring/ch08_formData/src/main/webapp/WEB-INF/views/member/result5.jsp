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
	<h2>result5.jsp페이지입니다(join5)</h2>
	<h4>이름: ${memberDto.name }</h4>
	<h4>아이디: ${memberDto.id }</h4>
	<h4>비밀번호: ${memberDto.pw }</h4>
	<h4>나이: ${memberDto.age }</h4>
	<h4>메일: ${memberDto.email }</h4>
	<h4>주소: ${memberDto.address }</h4>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conpath}'">홈으로</button>
</body>
</html>