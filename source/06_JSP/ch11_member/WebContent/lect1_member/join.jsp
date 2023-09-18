<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<script src="<%=conPath%>/js/join.js"></script>
</head>
<body>
	<form action="joinOk.jsp" method="post" name="join_frm">
		<table>
			<caption>회원가입</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
				<select name="phone1">
				<option></option>
				<option>010</option>
				<option>02</option>
				<option>031</option>
				<option>032</option>
				</select>
				<input type="text" name="phone2">
				<input type="text" name="phone3">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="m">남
					<input type="radio" name="gender" value="f">여
				</td>
			</tr>
			<tr>
				<th>메일</th>
				<td>
					<input type="email" name="email">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="date" name="tempBirth">
					<%--파라미터이름을birth로 하면bin태그 사용시 날짜를 입력하면500에러 --%>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" value="회원가입" onclick="infoConfirm()">
				<input type="reset" value="취소">
				<input type="button" value="로그인" onclick="location.href='login.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>