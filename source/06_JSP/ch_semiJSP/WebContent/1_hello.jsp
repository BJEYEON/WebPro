<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이파일은 hello.jsp입니다</h1>
	<%
		int total = 0;
		for(int cnt=1; cnt<=100; cnt++){
			total += cnt;
		}
	%>
	<h2>1ㅂ터 100까지 누적합은<%=total %></h2>
</body>
</html>