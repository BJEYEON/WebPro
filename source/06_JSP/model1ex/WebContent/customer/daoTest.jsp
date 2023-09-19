<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
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
	<h1>테스트 페이지</h1>
	<%
		CustomerDao dao = CustomerDao.getInstance();
		String cid = "aa";
		int result = dao.confirmID(cid);
		if(result == CustomerDao.CUSTOMER_EXISTENT){
			out.print("<h3>1. confirmID결과: " + cid + "는 중복된 아이디로 가입이 불가합니다.");
		}else{
			out.print("<h3>1. confirm결과:" + cid + "는 가입이 가능한 아이디 입니다");
			CustomerDto dto = new CustomerDto(cid, "111", "홍", null,null,null,null,null,null);
			result = dao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				out.print("<h3>2. join결과: " + cid + "로 회원가입성공</h3>");
			}else{
				out.print("<h3>2. join결과 회원가입실패");
			}
		}
		out.print("<h3>3. logincheck결과</h3>");
		cid = "a"; String cpw = "111";
		result = dao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("id는" + cid + ",pw는" + cpw + ":로그인성공<br>");
		}else{
			out.print("id는" + cid + "비번은" + cpw + ": 아이디 혹은 비밀번호를 잘못 입력했습니다.");
		}
		out.print("<h3>4. id로dto가져오기</h3>");
		CustomerDto dto = dao.getCustomer("aaa");
		out.print("id=aaa인dto:" + dto + "<br>");
		out.print("<h3>5.정보수정</h3>");
		out.print("id=aaa수정전 값:" + dao.getCustomer("aa") + "<br>");
		dto = new CustomerDto("aa", "1", "홍길자", "010-9999-8888","asd@asd.com","서울", null, "m",null);
		result = dao.modifyCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			out.print("db에 수정후 데이터" + dao.getCustomer("aa") + "<br>");
		}else{
			out.print(dto.getCid() + "수정실패");
		}
		
	%>
</body>
</html>