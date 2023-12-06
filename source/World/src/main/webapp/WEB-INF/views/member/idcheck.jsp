<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck.jsp</title>
<style type="text/css">
body{overflow-x:hidden;}
body h2{font-size:30px; border-bottom: 2px solid #e1e1e1; padding:0 0 20px 0;}

#middle {position:relative; width:100%; height:50px;}
#bottom {position:relative; width:100%; height:50px;}
#bottom1 {position:relative; width:100%; height:25px;}
#bottom2 {position:relative; width:100%; height:25px; padding:20px 0; text-align:center;}
form input {width:150px; height:20px; border:1px solid lightgray; background-color:#f7f7f7;
	border-radius:5px; font-size:16px;}
form .text {text-indent:10px;}
form .submit, form .cancel {width:80px; height:25px; background-color:#6f23f9; 
      border-radius:5px; font-size:16px; color:white;}
form .cancel {background:#6f23f9;} 
</style>
<script src="script/member.js"></script>
</head>
<body>
	<h2>아이디 중복 확인</h2>
	<form method="post" name="idCheckForm" action="idCheckForm">
		<div id="middle">
		<input type="hidden" name="command" value="idCheckForm"/>
		아이디 : <input type="text" name="id" class="text" value="${id}"/>
		<input type="submit" value="검색" class="submit">
		</div>
		<div id="bottom">
			<c:if test ="${result==1 }">
				<script type ="text/javascript">opener.document.joinForm.id.value="";</script>
				${id}는 이미 사용중입니다
			</c:if>
			<c:if test="${result == -1}">
				<div id="bottom1">
					${id}는 사용 가능한 ID입니다.<br>
				</div>
				<div id="bottom2">    
					<input type="button" value="사용" class="cancel" onclick="idok('${id}');">
				</div>
			</c:if>	
		</div>
	</form>
</body>
</html>