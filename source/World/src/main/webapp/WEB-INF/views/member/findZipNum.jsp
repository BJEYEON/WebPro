<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{overflow-x:hidden;}
body h2{font-size:30px; border-bottom: 2px solid #e1e1e1; padding:0 0 20px 0;}

#middle {position:relative; width:100%; height:50px;}
form input {width:150px; height:20px; border:1px solid lightgray; background-color:#f7f7f7;
	border-radius:5px; font-size:16px;}
form .text {text-indent:10px;}
form .submit{width:80px; height:25px; background-color:#6f23f9; 
      border-radius:5px; font-size:16px; color:white;}

table#zipcode{border-collapse:collapse; border-top:2px solid #e1e1e1; border-bottom:2px solid #e1e1e1;
       width:100%; font-size:16px;}
table#zipcode th, table#zipcode td{text-align:center; border-bottom: 1px dotted  #6F0C78;;}
table th, td{padding:10px;}
table#zipcode a{display:block; height:20px; text-decoration:none; padding:10px;}
table#zipcode a:hover{font-weight: bold;} 
</style>
<script src="member/member.js"></script>
</head>
<body>
	<h2>우편번호 검색</h2>
	<form action="world.do" method="post" name="formm">
		<div id="middle">
			<input type="hidden" name="command" value="findZipNum">
			동 이름 : <input type="text" name="dong" class="text">
			<input type="submit" value="찾기" class="submit">
		</div>
	</form>
	<!-- 검색된 우편번호와 동이 표시되는 곳 -->
	<table id="zipcode">
		<tr><th width="80">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="add">
			<tr>
				<td><a href="#" 
				onClick="result('${add.zip_num }','${add.sido}', '${add.gugun}', '${add.dong}');">
				${add.zip_num }</a></td>
				<td><a href="#" 
				onClick="result('${add.zip_num }','${add.sido}', '${add.gugun}', '${add.dong}');">
				${add.sido} ${add.gugun} ${add.dong}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>