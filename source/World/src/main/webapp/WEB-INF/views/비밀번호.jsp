<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="script/common.js"></script>
<script src="script/member.js"></script>
</head>
<body>
<div class="zipnum-wrap id-check-wrap">
<h2>비밀번호 찾기</h2>
<c:if test="${result == 0}">
<form method="post" name="formm" action="pf.do">
<input type="hidden" name="command" value="selectPwd" />
<table id="find-id">
<tr>
<th>아이디&nbsp;</th><td><input type="text" name="id" class="input-text input-text-bg-gray input-text-font-normal" maxlength="20" /></td>
</tr>
<tr>
<th>이름&nbsp;</th><td><input type="text" name="name" class="input-text input-text-bg-gray input-text-font-normal" maxlength="20" /></td>
</tr>
<tr>
<th>전화번호&nbsp;</th><td><input type="text" name="phone" class="input-text input-text-bg-gray input-text-font-normal" maxlength="20" /></td>
</tr>
</table>
<br />
<input type="button" value="찾기" class="submit submit-blue dup-btn" onclick="findPwdSubmit();" />
</form>
<br /><br />
</c:if>
<c:if test="${result == 1}">
<form method="post" name="joinForm" action="pf.do">
<input type="hidden" name="command" value="setPwd" />
<input type="hidden" name="id" value="${id}" />
<fieldset>
<div style="width:100px;">암호</div><input type="password" name="pwd" class="join-form-input" placeholder=" 암호를 입력하세요" maxlength="20" /><br />
<div style="width:100px;">암호 재입력</div><input type="password" name="pwdCheck" class="join-form-input" placeholder=" 암호를 입력하세요" maxlength="20" /><br />
</fieldset>
<div class="clear"></div>
<br />
<div class="buttons">
<input type="button" value="암호변경" class="submit submit-blue dup-btn" onclick="checkPwd();" />&nbsp;
<input type="reset" value="취소" class="cancel dup-btn" />
</div>
<br />
</form>
</c:if>
<c:if test="${result == 3}">
<script type="text/javascript">self.close();</script>
</c:if>
</div>
</body>
</html>