<%@page import="com.lec.dto.CustomerDto"%>
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
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.CustomerDto" scope="page"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempCbirth = request.getParameter("tempCbirth");
		if(! tempCbirth.equals("")){
			dto.setCbirth(Date.valueOf(tempCbirth));
		}
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		String sessionPw = null;
		if(customer!=null){
			sessionPw = customer.getCpw();// customer세션의pw
		}
		String oldPw = request.getParameter("oldCpw");
		if(sessionPw.equals(oldPw)){
			//현비번을 맞게 입력한 경우 정보수정진행
			if(dto.getCpw() == null){//새비번을 안입력한경우
				dto.setCpw(oldPw); //새시번을 현비번으로
			}
			CustomerDao cDao = CustomerDao.getInstance();
			int result = cDao.modifyCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				//정보수정성공
				session.setAttribute("customer", dto); //수정된정보를 세션 속성으로도 수정
	%>	
				<script>
				alert('정보수정이 완료되었습니다');
				location.href='<%=conPath%>/main/main.jsp';
				</script>
		<% 	}else{//수정실패%>
				<script>
					alert('정보수정이 실패 되었습니다. 정보가 너무 깁니다');
					location.href = 'modifyForm.jsp';
				</script>
			<%} %>
		<% 	}else{ //현 비밀번호를 잘못친경우%>
				<script>
					alert('현 비밀번호가 바르지 않습니다');
					history.back();
				</script>				
		<%} %>
	
</body>
</html>