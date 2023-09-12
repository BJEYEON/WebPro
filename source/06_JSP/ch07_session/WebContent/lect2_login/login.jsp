<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String conPath = request.getContextPath(); 
	//로그인 후에 로그인 페이지를 요청할 경우 welcome.jsp로 (로그인 안되게)
	if(session.getAttribute("name")!=null){
		response.sendRedirect(conPath + "/lect2_login/welcome.jsp");
	}
	//파라미터로 넘어온 msg처리
	String msg = request.getParameter("msg");
	if(msg!=null){
%>
	<script>
		alert('<%=msg%>');
	</script>
	<% }%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="<%=conPath%>/lect2_login/loginOk.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" required="required" autofocus="autofocus"
						 value="<% 
						 String id = (String)session.getAttribute("id");
						if(id!=null){
							out.print(id);
						}
				 		%>">
				 </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" class="btn">
					<input type="button" value="홈" class="btn" onclick="location.href='<%=conPath%>/lect2_login/welcome.jsp'">
					<input type="button" value="회원가입" class="btn" onclick="location.href='<%=conPath%>/lect3_join/join.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>