<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="6_loginPro.jsp" method="get">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="ename" /></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="로그인">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>