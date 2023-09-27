<%@page import="java.net.URLEncoder"%>
<%@page import="org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID"%>
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
	<form action="ex2_scope.jsp">
		<p>ID <input type="text" name="id"></p>
		<p>pw <input type="text" name="pw"></p>
		<p><input type="submit"></p>
	</form>
	<%
		// 자바에서 할 로직 
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requestValue");//★
		session.setAttribute("sessionName", "sessionValue");//★
		application.setAttribute("applName", "applValue");
		//자바에서 forward할 객체 생성후 forward
		/* RequestDispatcher dispatcher = request.getRequestDispatcher("ex2_scope.jsp");
		dispatcher.forward(request, response); */
		
		response.sendRedirect("ex2_scope.jsp?id="+URLEncoder.encode("한글아이디", "utf-8")+"&pw=111"); //url창이바뀜 request 객체가 새로 만들어짐
	%>
	<%-- <jsp:forward page="ex2_scope.jsp"/> --%>
	<h3>페이지 내attribute: <%=pageContext.getAttribute("pageNum") %></h3>
	<h3>request내 attribute: <%=request.getAttribute("requestName") %></h3>
	<h3>session 내 attribute: <%=session.getAttribute("sessionName") %></h3>
	<h3>application 내 attribute: <%=application.getAttribute("applName") %></h3>
	<hr>
	<h3>페이지 내attribute ${pageScope.pageName }</h3>
	<h3>request내 attribute &{requestScope.requestName}</h3>
	<h3>session내 attribute &{sessionScope.sessionName}</h3>
	<h3>application내 attribute &{applicationScope.applName}</h3>
	<hr>
	<h3>페이지 내attribute ${pageName }</h3>
	<h3>request내 attribute &{requestName}</h3>
	<h3>session내 attribute &{sessionName}</h3>
	<h3>application내 attribute &{applName}</h3>
</body>
</html>