<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청url : ex_forward.jsp?n=1  -->
	<h2>ex1_forward.jsp입니다</h2>
	<%--
		response.sendRedirect("ex2_forward.jsp");//주소창의url이 바뀜 == 새로운request요청
	--%>
	<jsp:forward page="ex2_forward.jsp"></jsp:forward><!-- 주소창의url이 안바뀐(reauest객체가 그대로) -->
</body>
</html>