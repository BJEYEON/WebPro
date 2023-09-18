<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<script>
		setTimeout(() => {
			location.href='main.jsp';
		}, 2000);
	</script>
</head>
<body>
	<%--
		session.invalidate();
		response.sendRedirect("main.jsp");
	--%>
	<%
		if(session.getAttribute("member")!=null){
			session.invalidate();
			out.print("<h2>로그아웃되었습니다. 잠시후 메인 페이지로 이동합니다</h2>");
		}else{
			out.print("<h2>로그인상태가 아닙니다. 잠시후 메인 페이지로 이동합니다</h2>");
		}
	%>
</body>
</html>