<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		#content_form{
			height: 550px; 
			padding-top:50px;
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<%
		int bid = Integer.parseInt(request.getParameter("bid"));
		String pageNum = request.getParameter("pageNum"); //ex1이나ex3에서 넘어왔으면 null
		BookDao bDao = BookDao.getInstance();
		BookDto book = bDao.getBook(bid);
	%>
	<table>
		<tr>
			<td rowspan="4"> <!-- 1행1열, 2행1열, 3행1열, 4행1열 -->
				<img src="<%=conPath %>/bookImg/<%=book.getBimage1() %>">
			</td>
			<td><%=book.getBid() %>번 도서 상세보기</td>
		</tr>
		<tr>
			<td><%=book.getBtitle() %></td> <!-- 2행2열 -->
		</tr>
		<tr>
			<td>
				<del><%=book.getBprice() %></del>
				<b>
					<%=book.getBprice() * (100-book.getBdiscount()) / 100 %>원<br>
					(<%=book.getBdiscount() %>% 할인)
				</b>
			</td>
		</tr>
		<tr>
			<td>
				<button>구매</button>
				<button onclick="location.href='ex4_list.jsp?pageNum=<%=pageNum%>'">목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="<%=conPath %>/bookImg/<%=book.getBimage2() %>"><br>
				<pre><%=book.getBcontent()==null? "-" : book.getBcontent() %></pre>
			</td>
		</tr>
	</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>