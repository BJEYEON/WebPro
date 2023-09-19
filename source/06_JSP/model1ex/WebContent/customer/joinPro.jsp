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
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempCbirth = request.getParameter("tempCbirth");
		if(! tempCbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempCbirth));
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.confirmID(dto.getCid()); //id중복체크
		if (result == CustomerDao.CUSTOMER_NONEXISTENT){
			result = cDao.joinCustomer(dto); //회원가입
			if(result==CustomerDao.SUCCESS){//회원가입성공
				session.setAttribute("id", dto.getCid());
	%>
				<script>
					alert('<%=dto.getCname()%>님 회원가입 감사합니다');
					location.href = 'loginForm.jsp';
				</script>
			<%}else{//회원가입 실패 %>
				<script>
					alert('회원가입이 실패되었습니다. 길이제한이 있습니다');
					histor.go(-1);
				</script>	
			<% }%>
		<% }else{ //중복된ip라서 이전페이지로%>
	
		<script>
			alert('중복된id입니다. 다른아이디를 입력하세요');
			history.back();
		</script>
		<%} %>
		 
	
</body>
</html>