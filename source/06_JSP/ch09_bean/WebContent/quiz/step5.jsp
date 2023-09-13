<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="st"/>
	<jsp:forward page="studentresult.jsp"></jsp:forward>
</body>
</html>