<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		String[] names = {"홍길동", "신길동", "김길동"};
		request.setAttribute("names", names);
		/* for(String name : names){
			out.print("<p>" + name + "</p>");
		}
		for(int i=0; i<names.length; i++){
			out.print("<p>" + i + "번쨰 : "  + names[i] + "</p>"); 
		} */
	%>
	<c:set var="names" value="<%=names %>"/> <!-- names라는 변수 선언및 할당 -->
	<c:forEach var="name" items="${names }">
		<p>${name }</p>
	</c:forEach>
	<hr>
	<c:forEach var="name" items="${names }" begin="0" end="1">
		<p>${name }</p>
	</c:forEach>
	<hr>
	<c:set var="idx" value="0"/> <!-- idx변수선언및할당0으로 -->
	<c:forEach var="name" items="${names }">
		<p>${idx }번째 : ${name }</p>
		<c:set var="idx" value="${idx+1 }"/> <!-- idx변수를 기존의 idx+1로 재선언 -->
	</c:forEach>
	<p>최종 idx값은 ${idx }입니다</p>
</body>
</html>