<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body { background-color: lightyellow;}
td{text-align: center; padding:2px 5px;}
#msg {color:red; text-align: center;}
</style>
<script>
	const position = id =>{
		location.href = 'loginPro.jsp?id=' + id;
	}
	const position = pw =>{
		location.href = 'loginPro.jsp?pw=' + pw;
	}
</script>
</head>
<body>
	<form action="loginPro.jsp" method="get">
	<table>
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
		<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.println(msg);
		}
		%>
	</table>
	</form>
</body>
</html>