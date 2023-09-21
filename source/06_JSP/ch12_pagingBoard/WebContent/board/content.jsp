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
		/*pageNum추가*/
		String pageNum = request.getParameter("pageNum");
		String bid = request.getParameter("bid"); //null이거나 "1"
		BoardDao bDao = BoardDao.getInstance();
		//list.jsp를 통해서 상세보기 페이지를 올때만 조회수1up
		//list.jsp를 통해서 상세보기 페이지를 올때url : content.jsp?bid=2
		//수정성공후 상세페이지로 옳때 url : content.jsp?bid=2&after=u
		if(request.getParameter("after")==null){
			bDao.hitup(bid);
		}
		BoardDto dto = bDao.getboardNotHitup(bid);//조회수1올리고 dto가져오기
		if (dto == null){
			response.sendRedirect(conPath + "/board/list.jsp");
		}else{
	%>
	<table>
		<caption><%=bid %>번 글 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td><%=dto.getBid() %></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><%=dto.getBtitle() %></td>
		</tr>
		<tr>
			<th>글본문</th>
			<td><pre><%=dto.getBcontent()==null? "" :dto.getBcontent()%></pre></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getBemail()==null? "" :dto.getBemail()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=dto.getBhit() %></td>
		</tr>
		<tr>
			<th>ip</th>
			<td><%=dto.getBip() %></td>
		</tr>
		<tr>
			<th>작성</th>
			<td><%=dto.getBdate() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='<%=conPath%>/board/updateForm.jsp?bid=<%=bid%>&pageNum=<%=pageNum%>'">수정</button>
				<button onclick="location.href='<%=conPath%>/board/deleteForm.jsp?bid=<%=bid%>&pageNum=<%=pageNum%>'">삭제</button>
				<button>답변</button>
				<button onclick="location.href='<%=conPath%>/board/list.jsp?&pageNum=<%=pageNum%>'">목록</button>
			</td>
		</tr>
	</table>
		
		<%}%>
</body>
</html>