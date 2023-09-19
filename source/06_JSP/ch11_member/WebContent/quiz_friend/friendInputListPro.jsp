<%@page import="com.lec.friend.FriendDao"%>
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
	<%request.setCharacterEncoding("utf-8");%>
	<jsp:useBean id="dto" class="com.lec.friend.FriendDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		FriendDao fDao = FriendDao.getInstance();
		String fname = dto.getFname();
		if(fname==null){
	%>	<script>
			alert('이름은 입력하세요');
		</script>		
	<% 
		}else{
			
		}
	
	%>
</body>
</html>