<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<form action="${conPath }/update.do" method="POST">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="empno" value="${param.empno }">
		<table>
			<caption>${empDto.empno }번 사원 정보 수정</caption>
			<tr>
				<th>이름</th>
				<td><input type="text" name="ename" value="${empDto.ename }"></td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" name="job" value="${empDto.job }"></td>
			</tr>
			<tr>
				<th>상사사번</th>
				<td><input type="number" name="mgr" value="${empDto.mgr }"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><input type="date" name="hiredate" value="${empDto.hiredate }" required="required"></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="number" name="sal" value="${empDto.sal }" required="required"></td>
			</tr>
			<tr>
				<th>상여</th>
				<td><input type="number" name="comm" value="${empDto.comm }"></td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td>
					<%-- <input type="number" name="deptno" value="${empDto.deptno }"> --%>
					<select name="deptno">
						<c:forEach items="${deptList }" var="dept">
							<option value="${dept.deptno }" 
								<c:if test="${dept.deptno eq empDto.deptno }">
									selected="selected"
								</c:if>
							>
								${dept.deptno } - ${dept.dname } - ${dept.loc }
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="목록"
					onclick="location.href='${conPath}/empDeptList.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>















