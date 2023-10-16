<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
	$(document).ready(function() {
		$('input[name="mid"]').keyup(function() {
			var mid = $(this).val();
			if (mid.length < 2) {
				$('#midConfirmResult').text('id는 2글자 이상입니다');
			} else {
				$.ajax({
					url : '${conPath}/midConfirm.do',
					type : 'get',
					data : 'mid=' + mid,
					dataType : 'html',
					success : function(data) {
						$('#midConfirmResult').html(data);
					},
					error : function(code){
						$('#midConfirmResult').html('error');
					}
				});
			}
		});
	});
</script>
<!-- $('#pw, #pwChk두 비밀번호 체크 -->
<script>
	$(document).ready(function() {
		$('.mpw, .mpwChk').keyup(function() {
			var pw = $('.mpw').val();
			var pwChk = $('.mpwChk').val();
			if (!pw && !pwChk) {
				$('#mpwChkResult').text('비밀번호를 입력하세요');
			} else if (pw == pwChk) {
				$('#mpwChkResult').text('두 비밀번호가 일치합니다');
			} else {
				$('#mpwChkResult').html('<b>비밀번호가 일치하지 않습니다</b>');
			}
		});
	});
</script>
<script>
$(document).ready(function() {
	var patternMemail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
	$('input[name="memail"]').keyup(function(){
		let memail = $(this).val();
		$('#memailConfirmResult').html(memail);
		if(!memail){
			$('#memailConfirmResult').html(' &nbsp; ');
		}else if(!patternMemail.test(memail)){
			$('#memailConfirmResult').html('<b>메일 형식을 지켜 주세요</b>');
		}else{
			$.ajax({
				url : '${conPath}/memailConfirm.do',
				type : 'post',
				//data : 'memail='+memail,
				data : {memail : memail},
				dataType : 'html',
				success : function(data){
					$('#memailConfirmResult').html(data);
				},
			});
		} 
	});
});
</script>
<!-- $('form')의 submit이벤트에 유효성 검사(#idConfirmResult, #pwChkResult)  -->
<!-- 								사용가능한id입니다	두 비밀번호가 일치합니다 -->
<script>
	$(function() {
		$('form').submit(function() {
			var idConfirmResult = $('#midConfirmResult').text().trim();
			var pwChkResult = $('#mpwChkResult').text().trim();
			if (idConfirmResult != '사용가능한id입니다') {
				alert('사용 가능한id인지 확인요망');
				return false;//submit제한
			} else if (pwChkResult != '두 비밀번호가 일치합니다') {
				alert('비밀번호를 확인하세요');
				$('#mpw').focus();
				return false;
			}
			return false;
		});
	});
</script>
<!--  생일입력란datepicker부분 -->
<script>
	$(function() {
		$(".mbirth").datepicker(
				{
					dateFormat : "yy-mm-dd",
					monthNames : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월",
							"8월", "9월", "10월", "11월", "12월" ],
					monthNamesShort : [ "1월", "2월", "3월", "4월", "5월", "6월",
							"7월", "8월", "9월", "10월", "11월", "12월" ],
					showMonthAfterYear : true,//년도뒤에 월을 표시
					yearSuffix : "년", //년도 뒤에"년"을 붙임
					changeMonth : true, //월을 바꿀 수 있는 셀렉트 박스를 표시
					changeYear : true, //년을 바꿀 수 있는 셀렉트 박스를 표시
					yearRange : "c-100:c+10", //년도 선택 셀렉트 박스를 현재년도에서 이전, 이후의 범위 설정
				});
	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="mid" class="mid" required="required" autofocus="autofocus" autocomplete="off">
						<div id="midConfirmResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" id="mpw" class="mpw" required="required"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="mpwChk" id="mpwChk" class="mpwChk" required="required">
						<div id="mpwChkResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" id="mname" class="mname" required="required"></td>
				</tr>
				<tr>
					<th>메일</th>
					<td>
						<input type="text" name="memail" autocomplete="off">
						<div id="memailConfirmResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="mphoto"></td>
				</tr>
				<tr>
					<th>생년월일</th><td><input type="text" name="mbirth" id="datepicker" class="mbirth" autocomplete="off"></td>
				</tr>
				<tr>
					<th>주소</th><td><input type="text" name="maddress"></td>
				</tr>
				<tr>
					<td colspan="2">
						<p>
							<input type="submit" value="회원가입" class="btn">
							<input type="button" value="로그인" class="btn" onclick="location='${conPath}/loginView.do'">
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>