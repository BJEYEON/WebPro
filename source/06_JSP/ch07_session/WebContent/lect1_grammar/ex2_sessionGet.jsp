<%@page import="com.lec.ex.Member"%>
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
	<h1>특정세션 값 가져오기</h1>
	<% //특정 세션 값 가져오기 (세션의 특정한 속성값 가져오기)
		String sessionName = (String)session.getAttribute("sessionName");
		Integer sessionNum = (Integer)session.getAttribute("sessionNum");
		Member member = (Member)session.getAttribute("member");
		String noSessionAttr = (String)session.getAttribute("noSessionAttr");
		out.print("<h2>sessionName:" + sessionName + "</h2>");
		out.print("<h2>sessionNum:" + sessionNum + "</h2>");
		out.print("<h2>member:" + member + "</h2>");
		if(member!=null){
			out.print("<h2>member안의id:" + member.getId() + "</h2>");
			out.print("<h2>member안의pw:" + member.getPw() + "</h2>");
			out.print("<h2>member안의name:" + member.getName() + "</h2>");
		}else{
			out.println("<h2>세션에member속성이 없습니다</h2>");
		}
	
	%>
	<h2>세션에 추가하지 않은 데이터: <%=noSessionAttr %></h2>
	<hr>
	<a href="ex1_sessionAddAttr.jsp">세션 데이터 추가</a><br>
	<a href="ex2_sessionGet.jsp">특정 세션 get</a><br>
	<a href="ex3_sessionList.jsp">세션의 모든 데이터 리스트</a><br>
	<a href="ex4_sessionRemove.jsp">세션 삭제(특정세션 데이터나 모든 세션데이터)</a><br>
</body>
</html>