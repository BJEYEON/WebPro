<%@page import="com.lec.ex.dao.BoardDao"%>
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
	<% 
		request.setCharacterEncoding("utf-8"); 
	%>
	<jsp:useBean id="dto" class="com.lec.ex.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setBip(request.getRemoteAddr()); //글쓰기 요청한컴퓨터ip
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.writeboard(dto);//db저장
		if(result == BoardDao.SUCCESS){
			//alert(성공) 리스트 페이지로
			//response.sendRedirect(conPath + "/board/list.jsp?result=" + result);
			//list.jsp?result=1
	%>
		<script>
			alert('글쓰기 완료');
			location.href = '<%=conPath%>/board/list.jsp';
		</script>
		<% }else{%>
			<script>
				alert('글쓰기 실패(길이)');
				history.back();
			</script>
		<%} %>	
		
</body>
</html>