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
	<h2>어떤 요청이 들어오던 cnt, list는 model에add됨</h2>
	<h4>cnt : ${cnt }</h4>
	<h4>list: ${list }</h4>
	<%-- <form action="${conPath }/member/join1" method="post">
	<form action="${conPath }/member/join2" method="post"> --%>
	<%-- <form action="${conPath }/member/join3" method="get"> --%>
	<%-- <form action="${conPath }/member/join4" method="get">
	<form action="${conPath }/member/join5" method="get"> --%>
	<form action="${conPath }/member/join6" method="get">
		<table>
			<caption>회원정보</caption>
			<tr><th>이름</th><td><input type="text" name="name"></td></tr>
			<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><th>나이</th><td><input type="number" name="age" required="required"></td></tr>
			<tr><th>이메일</th><td><input type="text" name="email"></td></tr>
			<tr><th>주소</th><td><input type="text" name="address"></td></tr>
			<tr><th colspan="2"><input type="submit"></th></tr>
		</table>
	</form>
	<!--  요청경로 studentId?에id=aaa(x) / studentId/aaa(ㅇ nest방식) -->
	<a href="${conPath }/studentId/aaa">studentId에 aaa로 전송</a>
	<a href="${conPath }/studentId/bbb">studentId에 bbb로 전송</a>
	<a href="${conPath }/studentId/홍길동">studentId에 홍길동로 전송</a>
</body>
</html>