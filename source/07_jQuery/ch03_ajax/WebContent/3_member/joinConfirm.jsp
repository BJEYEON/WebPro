<%@page import="com.lec.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
	// midConfirm.jsp?mid=son
	String mid = request.getParameter("mid");
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.midConfirm(mid);
	if(result == MemberDao.EXISTENT){
		out.println("<b>중복된 ID입니다</b>");
	}else{
		out.println("사용가능한id입니다");
	}
%>
</body>
</html>