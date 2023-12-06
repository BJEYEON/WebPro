<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script src="script/member.js"></script>
<link href="css/world.css" rel="stylesheet">
<style>
input {
  width: 230px;
  height: 32px;
  font-size: 10px;
  border: 0;
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(233, 233, 233);
}

</style>
</head>
<body>
<div class="findfind">
<div class="id_found">
   <h2 class="abcde">비밀번호 찾기</h2>
   <h5 style="text-align:center;margin-right:7px;">신원확인 후 재설정이 가능합니다</h5>
   <form method="post" name="formm" >
      <input type="hidden" name="command" value="selectPwd" />
      <table class="find-id">
         <tr>

         <th>아이디&nbsp;&nbsp;&nbsp;&nbsp;</th><td><input type="text" name="id" class="input-text"  value="${Lmember.id}" maxlength="30" /></td>

         </tr>
          </table>
          <table class="find-id">
         <tr>

         <th>&nbsp;이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><td><input type="text" name="name" class="input-text" maxlength="30" /></td>

         </tr>
           </table>
            <table class="find-id">
         <tr>

         <th>전화번호&nbsp;&nbsp;</th><td><input type="text" name="phone" class="input-text" maxlength="30" /></td>

         </tr>
      </table>
      <br />
        <div class="founf">
      <input type="button" value="찾기" class="button" onclick="find_Pwd();" /></div>
   </form>
    </div>
   <br />
   <c:choose>
  	 <c:when test="${not empty Lmember}">
    	  <h2><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원님의 비밀번호는 '${Lmember.pwd}' 입니다.</h2>
       	<div class="founff">
      		<input type="button" value="재설정" class="button" onclick="resetPwd();" />
      	</div>
   	</c:when>
   	<c:otherwise>
   			  <h2><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message}</h2>
   	</c:otherwise>
   </c:choose>
   
</div>

</body>
</html>
