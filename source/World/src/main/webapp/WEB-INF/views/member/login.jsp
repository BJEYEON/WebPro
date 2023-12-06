<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div id=logina>
   <div class="login">
   <div class="join_title">로그인</div>
   </div>
   <h2 style="color:gray; font-weight:400">회원아이디와 비밀번호로 로그인 하세요.</h2>
   <br><br>
   <form method="post" name="loginFrm">
   <!-- <input type="hidden" name="command" value="login">  action="world.do"-->
   <div id=input>
      <input name="id" placeholder="&nbsp;아이디" size="40" type="text" style="width:500px"><br>
   </div>
   <br>
   <div id=input>
      <input name="pwd" placeholder="&nbsp;비밀번호" size="40" type="password" style="width:500px"><br>
   </div>
   <div class="menu1">
      <ul>
          <li onclick="findId();"  style="cursor:pointer;">아이디 찾기 |</li>
          <li onclick="findPwd();" style="cursor:pointer;">&nbsp;비밀번호 찾기 |</li>
          <li onclick="go_contract();" style="cursor:pointer;">&nbsp;회원가입</li>
      </ul>
   </div>
   <div class="ar">${message}</div>
   <div id="buttons">
      <input type="submit" value="로그인" class="submit" onclick="loginCheck()">
      <br>
	  <a href="kakaostart" id="kakaoLogo">카카오계정으로 로그인</a>
   </div>
   <div id=content> 회원정보와 관련된 문의사항이 있으시면 고객만족센터에 연락하세요.<br>
   고객만족센터 : 1899-8900
   </div>
   </form>
</div>

<%@ include file="../footer.jsp" %>