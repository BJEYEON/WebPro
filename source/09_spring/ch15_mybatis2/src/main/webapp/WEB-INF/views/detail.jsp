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
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
<c:set var="success" value="1"/>
	<c:if test="${modifyResult eq success }">
		<script>alert('${param.empno}번 사원 정보 수정 성공');</script>
	</c:if>
	<table>
		<caption>직원정보</caption>
		<tr><th>사번</th><td>${empDto.empno }</td></tr>
		<tr><th>이름</th><td>${empDto.ename }</td></tr>
		<tr><th>직책</th><td>${empDto.job }</td></tr>
		<tr><th>상사사번</th><td>${empDto.mgr }</td></tr>
		<tr>
			<th>입사일</th>
			<td>
				<fmt:formatDate value="${empDto.hiredate }" pattern="yy년MM월dd일(E)"/>
			</td>
		</tr>
		<tr>
			<th>급여</th>
			<td>
				<fmt:formatNumber value="${empDto.sal }" groupingUsed="true"/>
			</td>
		</tr>
		<tr>
			<th>상여</th>
			<td>
				<fmt:formatNumber value="${empDto.comm }" groupingUsed="true"/>
			</td>
		</tr>
		<tr><th>부서번호</th><td>${empDto.deptno }</td></tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='${conPath}/empDeptList.do?pageNum=${param.pageNum }'">
					목록
				</button>
				<button onclick="location.href='${conPath}/update.do?empno=${param.empno }&pageNum=${param.pageNum }'">수정</button>
				<button onclick="location.href='${conPath}/delete.do?empno=${param.empno }&pageNum=${param.pageNum }'">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>















