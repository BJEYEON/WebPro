<%@page import="com.lec.ex.dao.BoardDao"%>
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
	<%
		/*pageNum추가*/
		String pageNum = request.getParameter("pageNum");
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bpw = request.getParameter("bpw");
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteboard(bid, bpw);
		if(result == BoardDao.SUCCESS){
	%>
		<script>
			alert('<%=bid%>번 글 삭제완료');
			location.href = '<%=conPath%>/board/list.jsp?pageNum=<%=pageNum%>';
		</script>
		<% }else{//bpw오류%>
			<script>
				alert('<%=bid%>번 글 삭제되지 않았습니다. 비밀번호를 확인하세요');
				history.back();
				//location.href = '<%=conPath%>/board/deleteForm.jsp?bid=<%=bid%>&pageNum=<%=pageNum%>';
			</script>
		<%} %>
</body>
</html>