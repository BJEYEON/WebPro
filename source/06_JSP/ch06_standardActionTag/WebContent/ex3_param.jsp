<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 요청url ex3_param.jsp?n=1 --%>
	<h2>ex3_param.jsp페이지 입니다</h2>
	<jsp:forward page="ex4.jsp">
		<jsp:param name="id" value="aaa" />
		<jsp:param name="pw" value="111" />
	</jsp:forward>
</body>
</html>