<%@page import="java.sql.Timestamp"%>
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
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>테스트 페이지</h1>
	<%
		CustomerDao cDao = CustomerDao.getInstance();
		String cid = "bbb";
		int result = cDao.confirmId(cid);
		if(result == CustomerDao.CUSTOMER_EXISTENT){
			out.println("<h3>1. confirmId결과 : " + cid+"는 있는 아이디입니다. 회원가입 불가합니다</h3>");
		}else{
			out.println("<h3>1. confirmId결과 : " + cid + "는 없는 아이디입니다. 회원가입 가능합니다</h3>");
			CustomerDto dto = new CustomerDto(cid, "111", "김길동", "010-9999-9999",
					"k@k.com", "서울", null, "f", null);
			result = cDao.joinCustomer(dto);
			if(result == CustomerDao.SUCCESS){
				out.println("<h3>2. join 결과 : 회원가입 성공:" + dto+ "</h3>");
			}else{
				out.println("<h3>2. join 결과 : 회원가입 실패 : " + dto+ "</h3>");
			}
		}
		out.println("<h3>3. 로그인 결과 </h3>");
		cid = "bbb"; String cpw = "111";
		result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL){
			out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 실패<br>");
		}
		cid = "xx"; cpw = "111";
		result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.LOGIN_SUCCESS){
			out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 성공<br>");
		}else if(result == CustomerDao.LOGIN_FAIL){
			out.print("id는 " + cid +", pw는 " + cpw + " : 로그인 실패<br>");
		}
		
		out.println("<h3>4. id로 dto가져오기</h3>");
		CustomerDto dto = cDao.getCustomer("qqq");
		out.println("qqq 아이디(없는 cid)인 member : " + dto + "<br>");
		dto = cDao.getCustomer("aaa");
		out.println("aaa 아이디인 member : " + dto + "<br>");
		
		
		out.println("<h3>5. 정보 수정 </h3>");
		dto.setCname("김수한무");
		dto.setCaddress("달나라");
		result = cDao.modifyCustomer(dto);
		if(result == CustomerDao.SUCCESS){
			out.println("수정완료<br>");
			out.println("db의 수정된 데이터 :" + cDao.getCustomer(dto.getCid()) +"<br>");
		}else{
			out.println(dto.getCid()+" 아이디는 없어서 수정 못했어요<br>");
		}
	%>
</body>
</html>