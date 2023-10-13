<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/join.css" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<!-- $('#id')의keyup이벤트에$.ajax()구현 -->
<script>
	$(document).ready(function(){
		$('input[name="mid"]').keyup(function(){
			var mid = $(this).val();
			if(mid.length < 2){
				$('#idConfirmResult').text('id는 2글자 이상입니다');
			}else{
				$.ajax({
					url: 'joinConfirm.jsp',
					type: 'post',
					data: 'mid='+$('input[name="mid]').val(),
					dataType: 'html',
					success:function(data){
						$('#idConfirmResult').html(data);
					},
				});
			}
		});
	});
</script>
	<!-- $('#pw, #pwChk두 비밀번호 체크 -->
<script>
	$(document).ready(function() {
		$('.pw, .pwChk').keyup(function(){
			var pw = $('.pw').val();
			var pwChk = $('.pwChk').val();
			if(!pw &&!pwChk){
				$('#pwChkResult').text('비밀번호를 입력하세요');
			}else if(pw == pwChk){
				$('#pwChkResult').text('두 비밀번호가 일치합니다');
			}else{
				$('#pwChkResult').html('<b>비밀번호가 일치하지 않습니다</b>');
			}
		});
	});
			
</script>
	<!-- $('form')의 submit이벤트에 유효성 검사(#idConfirmResult, #pwChkResult)  -->
	<!-- 								사용가능한id입니다	두 비밀번호가 일치합니다 -->
	<script>
		$(function(){
			$('form').submit(function(){
				var idConfirmResult = $('#idConfirmResult').text().trim();
				var pwChkResult = $('#pwChkResult').text().trim();
				if(idConfirmResult != '사용가능한id입니다'){
					alert('사용 가능한id인지 확인요망');
					return false;//submit제한
				}else if(pwChkResult != '두 비밀번호가 일치합니다'){
					alert('비밀번호를 확인하세요');
					$('#pw').focus();
					return false;
				}
				return false;
			});
		});
	</script>
	<!--  생일입력란datepicker부분 -->
	<script>
	  $( function() {
	    $( ".birth" ).datepicker({
	    	dateFormat: "yy-mm-dd",
	    	monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
	    	monthNamesShort: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
	    	showMonthAfterYear: true,//년도뒤에 월을 표시
	    	yearSuffix: "년", //년도 뒤에"년"을 붙임
	    	changeMonth: true, //월을 바꿀 수 있는 셀렉트 박스를 표시
	    	changeYear: true, //년을 바꿀 수 있는 셀렉트 박스를 표시
	    	yearRange: "c-100:c+10", //년도 선택 셀렉트 박스를 현재년도에서 이전, 이후의 범위 설정
	    });
	  } );
  </script>
</head>
<body>
	<div id="joinForm_wrap">
		<form>
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td>
						<input type="text" name="mid" id="id" class="id" required="required">
						<div id="idConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" class="pw"></td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td>
						<input type="password" name="pwChk" id="pwChk" class="pwChk">
						<div id="pwChkResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" class="name"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birth" class="birth"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>