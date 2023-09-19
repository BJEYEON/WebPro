<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.lec.friend.FriendDao"%>
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
		String fname = request.getParameter("fname");
		if(fname==null){
			fname="";
		}
	%>
	<form action="friendInputListPro.jsp">
	<p>
		이름<input type="text" name="name" required="required">
		전화<input type="text" name="tel">
		<input type="submit" value="추가">
		</p>
		
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
	<%	
		
		FriendDao dao = FriendDao.getInstance();
		ArrayList<FriendDto> friendDtos = dao.friendList();
		if(friendDtos.size()!=0){
			for(FriendDto frienddto: friendDtos){
				out.print("<tr><td>" + frienddto.getFtel() + "</td>"
						+ "<td>" + frienddto.getFname() + "</td>"
						+ "<td>" + frienddto.getFtel() + "</td>");
			}
		}else{
			out.print("<tr>td colspan='3'>친구가 없습니다</td></tr>");
		}
		/* FriendDao dao = new */ 
	
	%>
	</table>
	
</body>
</html>