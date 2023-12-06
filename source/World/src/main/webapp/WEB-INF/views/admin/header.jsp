<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World admin</title>
<script src="script/admin.js"></script>
<script src="script/jquery-3.6.4.js"></script>
<script src="script/script.js"></script>
<link href="css/admincss.css" rel="stylesheet"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>

<body>
<div id="wrap">
	<header>
		<nav id ="top_menu">
			<ul>
				<li><a href="adminLogout">logout</a></li>
				<li>${name}(${workId})</li>
			</ul>
		</nav>
		
		<div id="sub_menu">
			<div class="logo">
				<a href="adminMain">
					<img src="images/mainlogo.jpg"/>
				</a>
			</div>
			
			<div class="category">
				<ul class="category_top_menu">	
					<li><a href="adminAttraction?first=y">어트랙션 관리</a></li>
					<li><a href="adminNotice?first=y">공지사항 관리</a></li>
					<li><a href="adminMember?first=y">회원 관리</a></li>
					<li><a href="adminQna?first=y">Q & A 관리</a></li>
					<li><a href="adminBannerList?first=y">배너관리</a></li>
				</ul>		
			</div>
		</div>
</header>

