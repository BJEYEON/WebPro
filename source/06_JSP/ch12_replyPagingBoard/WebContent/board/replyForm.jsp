pstmt.setString(5, dto.getBpw());<%@page import="com.lec.ex.dto.BoardDto"%>
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
		//넘어온 파라미터: bid(원글의 글번호), pageNum
		String pageNum = request.getParameter("pageNum");
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = BoardDao.getInstance();
		BoardDto originalDto = bDao.getboardNotHitup(bid); //원글의정보
	%>
	원글정보: <%=originalDto %>
	<form action="<%=conPath%>/board/replyProPro.jsp" method="post">
		<table>
			<caption>답변글쓰기</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="" name="bcontent"></textarea>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="bemail"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="bpw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" onclick="location.href='<%=conPath %>/board/list.jsp'">
		</table>
	</form>
</body>
</html>