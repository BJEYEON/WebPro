<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="joinForm_wrap">
	<div id="join_title">회원가입</div>
	<form action="/ch04_servlet/join" method="post">
		<table>
			<tr>
				<th><label for="name">이름</label></th>
				<td>
					<input type="text" name="name" class="name" id="name"
						required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th><label for="id">아이디</label></th>
				<td>
					<input type="text" name="id" class="id" id="id"
						required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th><label for="pw">비밀번호</label></th>
				<td>
					<input type="password" name="pw" class="pw" id="pw"
						required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th><label for="pwChk">비밀번호확인</label></th>
				<td>
					<input type="password" name="pwChk" class="pwChk" id="pwChk"
						required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th><label for="name">생년월일</label></th>
				<td>
					<input type="date" name="birth" class="birth" id="birth"
						required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="checkbox" name="rest" value="독서">독서
					<input type="checkbox" name="rest" value="요리">요리
					<input type="checkbox" name="rest" value="운동">운동
					<input type="checkbox" name="rest" value="취침">취침</td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="성별" value="남자">남자
					<input type="radio" name="성별" value="여자">여자</td>
			</tr>
			<tr>
				<th><label for="pw">이메일</label></th>
				<td>
					<input type="text" name="email" class="email" id="email"
						required="required" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<th>이메일 수신</th>
				<td>
				<select multiple="multiple" name="mailSend">
					<option value="광고">광고</option>
					<option value="배송">배송</option>
					<option value="공지">공지</option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" id="joinBtn_style" name="joinBtn_style" class="joinBtn_style" value="회원가입">
				<input type="reset" id="joinBtn_style" name="joinBtn_style" class="joinBtn_style" value="취소">
				<input type="button" id="joinBtn_style" name="joinBtn_style" class="joinBtn_style" value="뒤로가기" onclick="history.back();">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>