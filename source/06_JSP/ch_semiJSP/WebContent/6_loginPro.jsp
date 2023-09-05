<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% 
		request.setCharacterEncoding("utf-8"); //post방식 전송시 추가
		String ename = request.getParameter("ename");
		String id = request.getParameter("id");
		String pw =  request.getParameter("pw");
	%>
	
	<table>
		<tr>
			<td><%="아이디는" + id + "이고" %><br></td>
		</tr>
		<tr>
			<td><%="비밀번호는" + pw + "입니다" %><br></td>
		</tr>
		<tr>
			<td><%= ename + "님 반갑습니다" %><br></td>
		</tr>
	</table>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='6_login.jsp'">로그인</button>
</body>
</html>