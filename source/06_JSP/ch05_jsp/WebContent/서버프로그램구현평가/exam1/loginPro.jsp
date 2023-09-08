<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! String id; String pw; String idr = "aaa"; String pwr = "111"; %>
	<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	if(id==null || pw==null || !id.equals(idr) || !pw.equals(pwr)){
		String msg = "Check the ID and PW!";
		response.sendRedirect("login.jsp?msg=" + msg);
	}else{
		//response.sendRedirect("login.jsp");
	}
		 %>
	<div>
		<h2>아이디는 <%=id %>이고</h2>
		<h2>비밀번호는 <%=pw %>입니다</h2>
		<hr>
		<h2>반갑습니다</h2>
		
	</div>
</body>
</html>