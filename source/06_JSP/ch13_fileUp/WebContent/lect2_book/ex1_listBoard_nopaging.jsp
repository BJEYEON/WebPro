<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
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
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook();
	%>
	<table>
		<caption>책 리스트(board style)</caption>
		<tr><th>책id</th><th>책이름</th><th>책표지</th><th>가격</th><th>할인율</th></tr>
		<%if(books.size()==0){
			out.print("<tr><td colspan='5'>등록된 책이 없습니다</td</tr>");
		}else{
			for(BookDto book : books){
				int bid = book.getBid();
				int price = book.getBprice();
				int discount = book.getBdiscount();
				int disprice = price * (100-discount) / 100;
				out.print("<tr>");
				//책id
				out.print("<td>" + bid + "</td>");
				//책이름(클릭시 상세보기 content.jsp?bid=2)
				out.print("<td><a href='content.jsp?bid="+bid+"'>" + book.getBtitle() + "</a></td>");
				
				//out.print("</tr>");
				//책표지(클릭시 상세보기)
				out.print("<td><a href='content.jsp?bid="+bid+"'>");
				out.print("<img src='../bookImg/"+book.getBimage1()+"' alt='대표이미지' width='15'>");
				out.print("</a></td>");
				//책가격
				out.print("<td><del>" + price + "</del><b>" + disprice + "원</b></td>");
				//할인율
				out.print("<td>" + discount + "</td>");
				out.print("</tr>");
			}
		}
	%>
	</table>
</body>
</html>