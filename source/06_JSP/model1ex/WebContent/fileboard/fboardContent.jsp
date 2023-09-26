<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet"
	type="text/css">
<style>
#content_form {
	padding: 40px;
}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="content_form">
		<%
			/*pageNum추가*/
		String pageNum = request.getParameter("pageNum");
		int fid = Integer.parseInt(request.getParameter("fid")); //null이거나 "1"
		FileBoardDao fDao = FileBoardDao.getInstance();
		//list.jsp를 통해서 상세보기 페이지를 올때만 조회수1up
		//list.jsp를 통해서 상세보기 페이지를 올때url : content.jsp?bid=2
		//수정성공후 상세페이지로 옳때 url : content.jsp?bid=2&after=u
		if (request.getParameter("after") == null) {
			fDao.hitup(fid);
		}
		FileBoardDto dto = fDao.getboardNotHitup(fid) ;//조회수1올리고 dto가져오기 return타입이 있는경우
		
		/* if (dto == null) {
			response.sendRedirect(conPath + "/fileboard/fboardList.jsp");
		} else {  */
			//fid값이없으면 fboardList로가게
		%>
		<table>
			<caption><%=fid%>번 글 상세보기
			</caption>
			<tr>
				<th>글번호</th>
				<td><%=dto.getFid()%></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><%=dto.getFtitle()%></td>
			</tr>
			<tr>
				<th>글본문</th>
				<td><pre><%=dto.getFcontent() == null ? "" : dto.getFcontent()%></pre></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=dto.getFhit()%></td>
			</tr>
			<tr>
				<th>ip</th>
				<td><%=dto.getFip()%></td>
			</tr>
			<tr>
				<td colspan="2">
					<button
						onclick="location.href='<%=conPath%>/fileboard/fboardUpdateForm.jsp?bid=<%=fid%>&pageNum=<%=pageNum%>'">수정</button>
					<button
						onclick="location.href='<%=conPath%>/fileboard/fboardDeleteForm.jsp?bid=<%=fid%>&pageNum=<%=pageNum%>'">삭제</button>
					<button
						onclick="location.href='<%=conPath%>/fileboard/fboardReplyForm.jsp?bid=<%=fid%>&pageNum=<%=pageNum%>'">답변</button>
					<button
						onclick="location.href='<%=conPath%>/fileboard/fboardList.jsp?&pageNum=<%=pageNum%>'">목록</button>
				</td>
			</tr>
		</table>
		
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>

</html>