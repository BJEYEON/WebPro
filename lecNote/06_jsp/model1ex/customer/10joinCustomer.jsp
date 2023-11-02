<%@page import="java.sql.Date"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
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
	<%
		CustomerDto c = new CustomerDto();
		CustomerDao cDao = CustomerDao.getInstance();
		for(int i=0 ; i<10 ; i++){
			c.setCid("aa"+i);
			c.setCpw("111");
			if(i%2==0){
				c.setCname("김마리");
				c.setCgender("f");
			}else{
				c.setCname("이봉창");
				c.setCgender("m");
			}
			c.setCtel("010-8888-888"+i);
			c.setCemail("koread"+i+"@naver.com");
			c.setCaddress("서울시 xx구 xx동 "+i);
			c.setCbirth(Date.valueOf("1991-02-2"+i));
			cDao.joinCustomer(c);
		}
		response.sendRedirect("../main/main.jsp");
%>
</body>
</html>