<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<style>
.dropdown{position : relative;display : inline-block;margin:0 auto;}
.dropbtn{border : 1px solid white;border-radius : 4px;background-color: white;font-weight: bold;color : rgb(37, 37, 37);padding : 12px;width :200px;text-align: center;cursor : pointer;font-size : 140%;}
.dropbtn:hover{color: blue; font-weight: bold;}
.dropdown-content{display : none;position : absolute;z-index : 1; font-weight: 400;background-color: white;min-width : 200px;}
.dropdown-content a{ display : block;text-decoration : none;color : rgb(37, 37, 37); font-size: 140%;padding : 12px 20px;font-weight:bold;}
.dropdown-content a:hover{color: purple; font-weight: bold;}
.dropdown:hover .dropdown-content {display: block;}

.category { position:relatiove; width: 1300px; height:85px; margin:0 auto; }
.category_top_menu li{  display:block;  height:10px;float:left; font-family: '맑은 고딕';
	 font-size:140%; margin: 20px 0 10px 80px; font-weight:bold;}
.category_top_menu li:hover { color: blue; font-weight: bold;} 
</style>

</head>
<body>
 <!-- <div class="category">
				<ul class="category_top_menu">	
					<li><a href="world.do?command=attractionForm">어트렉션</a></li>
					<li><a href="world.do?command=parade">퍼레이드</a></li>
					<li><a href="world.do?command=reserve">예매하기</a></li>
					<li><a href="world.do?command=guide">이용가이드</a></li>
					<li><a href="world.do?command=notice">공지사항</a></li>
					<li><a href="world.do?command=qna">Q&amp;A</a></li>
					<li><a href="world.do?command=event01">이달의 혜택</a></li>
				</ul>		
			</div>  -->
			
    <div class="dropdown">
      <button class="dropbtn"> 
        <span>즐길거리</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=attractionForm">어트렉션</a>
        <a href="world.do?command=parade">퍼레이드</a>
      </div>
    </div>
    <div class="dropdown">
      <button class="dropbtn"> 
        <span >예매하기</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=reserve">예매</a>
        <a href="world.do?command=event01">이달의 혜택</a>
      </div>
    </div>
    <div class="dropdown">
      <button class="dropbtn"> 
        <span >이용가이드</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=guide">운영/운휴</a>
        <a href="#">오시는 길</a>
      </div>
    </div>
    <div class="dropdown">
      <button class="dropbtn"> 
        <span >소통서비스</span>
      </button>
      <div class="dropdown-content">
        <a href="world.do?command=notice">공지사항</a>
        <a href="world.do?command=qna">Q&amp;A</a>
      </div>
    </div>
</body>
</html>