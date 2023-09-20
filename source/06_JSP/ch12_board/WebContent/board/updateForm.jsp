<%@page import="com.lec.ex.dto.BoardDto"%>
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
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = BoardDao.getInstance();
		BoardDto dto = bDao.getboardNotHitup(bid); // 조회수 안올리고 dto가져오기
	%>
	<form action="<%=conPath%>/board/updatePro.jsp" method="post">
		<input type="hidden" name="bid" value="<%=dto.getBid() %>">
		<table>
			<caption><%=bid %>번글 수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required" value="<%=dto.getBname() %>" autofocus="autofocus"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="btitle" required="required" value="<%=dto.getBtitle()%>"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="" name="bcontent"><%=dto.getBcontent()==null? "" :dto.getBcontent() %></textarea>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="bemail" value="<%
															String email = dto.getBemail();
															if(email!=null){
																out.print(email);
															}
															%>">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="bpw" required="required" value="<%=dto.getBpw()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글수정" class="btn">
					<input type="reset" value="취소" class="btn" onclick="history.back()">
					<input type="button" value="목록" class="btn" onclick="location.href='<%=conPath %>/board/list.jsp'">
		</table>
	</form>
</body>
</html>