<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World</title>
<script src="script/jquery-3.6.4.js"></script>
<script src="script/script.js"></script>
<script src="script/event02.js"></script>  
<script src="script/member.js"></script>
<link href="css/world.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<header>
		<div id ="top_menu">
			<ul>
				<c:choose>
					<c:when test ="${empty loginUser}">
						<li><a href="loginForm">login</a></li>
						<li><a href="/contract">회원가입</a></li>
						<li><a href="/admin">관리자</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="cartList">마이페이지</a></li>
						<li><a href="logout">logout</a></li>
						<li><a href="editForm">정보수정</a></li>
						<li>${loginUser.name}(${loginUser.id})</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div id="sub_menu">
			<div class="logo">
				<a href="/mobilemain">
					<img src="images/mainlogo.jpg"/>
				</a>
			</div>
			<div class="category">
				<div class="dropdown">
					<button class="dropbtn"> 
						<span>즐길거리</span>
					</button>
					<div class="dropdown-content">
						<a href="/mobileAttractionForm">어트렉션</a>
						<a href="/mobileParade">퍼레이드</a>
					</div>
				</div>
				<div class="dropdown">
					<button class="dropbtn"> 
						<span>예매하기</span>
					</button>
					<div class="dropdown-content">
			        	<a href="reserve">예매</a>
			        	<a href="mobileEvent01">이달의 혜택</a>
					</div>
				</div>
				<div class="dropdown">
					<button class="dropbtn"> 
						<span>이용가이드</span>
					</button>
					<div class="dropdown-content">
						<a href="guide">운영/운휴</a>
						<a href="howCome">오시는 길</a>
					</div>
				</div>
				<div class="dropdown">
					<button class="dropbtn"> 
						<span>소통서비스</span>
				    </button>
				    <div class="dropdown-content">
						<a href="mobileNotice">공지사항</a>
						<a href="mobileQna">Q&amp;A</a>
				    </div>
				</div>
			</div>
		</div>
	</header>
