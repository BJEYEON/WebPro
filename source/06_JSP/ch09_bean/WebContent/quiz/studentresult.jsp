<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 뷰단 -->
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<h2>입력받은 학생정보</h2>
	<p>학번<jsp:getProperty property="str_studentNum" name="st"/></p>
	<p>이름<jsp:getProperty property="str_name" name="st"/></p>
	<p>학년<jsp:getProperty property="int_grade" name="st"/></p>
	<p>반<jsp:getProperty property="str_class" name="st"/></p>
	<p>점수<jsp:getProperty property="int_score" name="st"/></p>
</body>
</html>