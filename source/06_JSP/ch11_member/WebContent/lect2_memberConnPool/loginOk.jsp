<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String method = request.getParameter("method"); //"null"또는modify
		MemberDaoCP mDao = new MemberDaoCP();
		int result = mDao.loginCheck(id, pw);
		if(result == MemberDaoCP.LOGIN_SUCCESS){ //로그인 성공
			MemberDto member = mDao.getmeMember(id);
			session.setAttribute("member", member);
			if(method.equals("null")){
				response.sendRedirect("main.jsp");
			}else{
				response.sendRedirect(method + ".jsp");
			}
		}else if(result == MemberDaoCP.LOGIN_FAIL_PW){ //pw오류
	%>
			<script>
				alert("비밀번호를 확인하세요");
				history.back();
			</script>
	<%	}else if(result == MemberDaoCP.LOGIN_FAIL_ID){//id오류%>
			<script>
				alert("아이디를 확인하세요");
				history.back();
			</script>
		 <%}%>
</body>
</html>