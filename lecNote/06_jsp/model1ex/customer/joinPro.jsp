<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempCbirth = request.getParameter("tempCbirth"); // ""이거나 "1995-12-12"
		if(!tempCbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempCbirth));
			// dto의 birth가 Timestamp형이면 : dto.setBirth(Timestamp.valueOf(tempBirth+" 00:00:00"));
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.confirmId(dto.getCid()); // ID 중복체크
		if(result == CustomerDao.CUSTOMER_NONEXISTENT){
			// 사용가능한 ID라서 회원가입 진행
			result = cDao.joinCustomer(dto); // 회원가입
			if(result == CustomerDao.SUCCESS){
				// 회원가입 성공시 cid 세션에 추가
				session.setAttribute("cid", dto.getCid());
	%>
				<script>
					alert('회원가입 감사합니다');
					location.href = '<%=conPath%>/customer/loginForm.jsp';
				</script>
	<%	}else{ // 회원가입 실패%>
				<script>
					alert('회원가입이 실패되었습니다. 길이 제한이 있습니다');
					history.back();
					//location.href = '<%=conPath%>/customer/join.jsp';
				</script>
	<%	}%>
	<%}else{// 중복된 ID라서 join.jsp로%>
			<script>
				alert('중복된 ID입니다. 다른 아이디를 사용하세요');
				history.back();
			</script>
	<%}	%>
</body>
</html>