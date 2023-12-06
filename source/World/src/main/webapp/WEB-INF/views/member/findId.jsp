<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디(ID) 찾기</title>
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
   <h2 class="abcd">아이디(ID) 찾기</h2>
   <form method="post" name="formm" >
      <input type="hidden" name="command" value="selectId" />
      <table class="find-id">
         <tr>
         <th>&nbsp;&nbsp;&nbsp;이름&nbsp;&nbsp;&nbsp;&nbsp;</th><td><input type="text" name="name" class="input-text" maxlength="20" /></td>
         </tr>
         </table>
      <table class="find-id">
         <tr>
         <th>전화번호&nbsp;&nbsp;</th><td><input type="text" name="phone" class="input-text" maxlength="20" /></td>
         </tr>
      </table>
      
      <br />
      <div class="founf">
      <input type="button" value="찾기" class="button" onclick="find_Id();" /></div>
      <h2>${message}</h2>
   <c:if test="${not empty Lmember}">
      <h2>회원님의 아이디는 '${Lmember.id}' 입니다.</h2>
   </c:if>
   </form>
   </div>
   
</div>
</body>
</html>