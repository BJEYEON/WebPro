<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
		<style>
			#content_form{padding: 40px;}
		</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="<%=conPath%>/fileboard/fboardWritePro.jsp" method="post" enctype="multipart/form-data">
			<table>
				<caption>원글쓰기</caption>
				<tr>
					<th>글제목</th>
					<td><input type="text" name="ftitle" required="required"></td>
				</tr>
				<tr>
					<th>본문</th>
					<td><textarea rows="5" cols="" name="fcontent"></textarea>
				</tr>
				<tr>
					<th>파일</th>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="fpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="글쓰기" class="btn">
						<input type="reset" value="초기화" class="btn">
						<input type="button" value="목록" class="btn" onclick="location.href='<%=conPath %>/fileboard/fboardList.jsp'">
			</table>
		</form>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>