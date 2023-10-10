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
	<c:if test="${empty member }">
		<script>
			location.href='${conPath}/loginView.do?next=modifyView.do';
		</script>
	</c:if>
	<form action="${conPath }/modify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="dbMpw" value="${member.mpw }">
		<input type="hidden" name="dbMphoto" value="${member.mphoto }">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" value="${member.mid }" size="3" required="required"></td>
				<td rowspan="4">
					<img src="${conPath }/memberPhotoUp/${member.mphoto}" alt="${member.mname }사진">
				</td>
			</tr>
			<tr>
				<th>현비밀번호</th>
				<td><input type="password" name="oldMpw" size="3" value="${member.mpw }" required="required"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="mpw" size="3"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname" value="${member.mname }" required="required" size="3"></td>
			</tr>
			<tr>
				<th>메일</th>
				<td colspan="2">
					<input type="email" name="memail" value="${member.memail }">
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td colspan="2">
					<input type="file" name="mphoto">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td colspan="2">
					<input type="date" name="mbirth" value="${member.mbirth }">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="2">
					<input type="text" name="madress" value="${member.maddress }">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<p>
					 	<input type="submit" value="정보수정">
					 	<input type="reset" value="초기화">
					 	<input type="reset" value="취소" onclick="location.href='${conPath}/main.do'">
					 	<input type="button" value="회원탈퇴" onclick="location.href='${conPath}/withdrawal.do'">
					</p>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>