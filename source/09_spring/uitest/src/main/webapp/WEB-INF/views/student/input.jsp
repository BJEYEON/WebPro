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
	<form action="${conPath }/input.do" method="post">
		<table>
			<caption>개인정보 입력</caption>
			<tr><th>이름: </th><td><input type="text" name="name" required="required"></td></tr>
			<tr><th>국어: </th><td><input type="number" name="kor" min=0 max=100></td></tr>
			<tr><th>영어: </th><td><input type="number" name="eng" min=0 max=100></td></tr>
			<tr><th>수학: </th><td><input type="number" name="math" min=0 max=100></td></tr>
			<tr><th colspan="2"><input type="submit"></th></tr>
		</table>
	</form>
</body>
</html>