<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	
	<c:if test="${joinResult eq SUCCESS }">
		<script>alert('1. 회원가입성공')</script>
	</c:if>
	<c:if test="${joinResult eq FAIL }">
		<script>alert('1. 회원가입 실패'); history.back()</script>
	</c:if>
	
	<!-- request.setAttribute("joinResult", result); 이거 매세지 -->
	
	<%-- <c:if test="${not empty joinMsg }">
		<script>alert('2. ${joinMsg}');</script>
	</c:if> --%> 
	<table>
		<tr><th>순번</th><th>ID</th><th>PW</th><th>이름</th><th>생일</th><th>가입</th></tr>
		<c:if test="${memberList.size() eq 0}">
			<tr><td colspan="6">가입한 회원이 없습니다</td></tr>
		</c:if>
		<c:if test="${memberList.size() != 0 }">
			<c:set var="no" value="1"/> <!-- 순번을 출력할 no변수 선언 -->
			<c:forEach var="member" items="${memberList }">
				<tr>
					<td>${no }</td>
					<td>${member.id }</td>
					<td>${member.pw }</td>
					<td>${member.name }</td>
					<td>
						<fmt:formatDate value="${member.birth }" pattern="MM월dd일"/>
					</td>
					<td>
						<fmt:formatDate value="${member.rdate }" pattern="yy-MM-dd hh:mm(a)"/>
					</td>
				</tr>
				<c:set var="no" value="${no+1 }"/> <!-- 순번을 출력할 no변수 재선언 -->
			</c:forEach>
		</c:if>
	</table>
	<p>
		<button onclick="location.href='${conPath}/memberJoinView.do'">회원가입</button>
	</p>
</body>
</html>