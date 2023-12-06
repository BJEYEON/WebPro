<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.category {width: 1300px;margin: 0 auto; }
.category_top_menu {display: flex; width: 100%; height: 100px; position: relative;}
.category .category_top_menu li {display: block; font-family: '맑은 고딕'; font-size: 140%; margin: 20px 0; font-weight: bold; cursor: pointer; position: relative;}
.category .category_top_menu li:hover {color: blue; font-weight: bold;}
.category .category_top_menu li .subcategory {display: none; position: absolute; top: 100%; left: 0; width: 100%; background-color: white; border: 1px solid black; padding: 10px; box-sizing: border-box;}
.category .category_top_menu li:hover .subcategory {display: flex; flex-direction: row; justify-content: flex-start;}
.category .category_top_menu li .subcategory ul {list-style-type: none; margin: 0; padding: 0;}
.category .category_top_menu li .subcategory ul li {margin-right: 10px;}
</style>

<script>
    function toggleSubcategory(index) {
        var subcategories = document.getElementsByClassName('subcategory');
        var activeSubcategory = document.getElementsByClassName('active')[0];
        if (activeSubcategory) {
            activeSubcategory.classList.remove('active');
        }
        subcategories[index].classList.add('active');
    }
    
    function showSubcategory(index) {
        var subcategories = document.getElementsByClassName('subcategory');
        var activeSubcategory = document.getElementsByClassName('active')[0];
        if (activeSubcategory) {
            activeSubcategory.classList.remove('active');
        }
        subcategories[index].classList.add('active');
    }
    
    function hideSubcategory() {
        var subcategories = document.getElementsByClassName('subcategory');
        var activeSubcategory = document.getElementsByClassName('active')[0];
        if (activeSubcategory) {
            activeSubcategory.classList.remove('active');
        }
    }
</script>
</head>
<body>

<div class="category">
    <ul class="category_top_menu">
        <li onmouseover="showSubcategory(0);" onmouseout="hideSubcategory();">
            즐길거리&nbsp;&nbsp;
            <div class="subcategory" style="width:1300px; border:1px solid green">
                <ul>
                    <li><a href="world.do?command=attractionForm">어트렉션</a></li>
                    <li>페스티벌</li>
                </ul>
            </div>
        </li>
        <li onmouseover="showSubcategory(1);" onmouseout="hideSubcategory();">
            예매하기&nbsp;&nbsp;
            <div class="subcategory" style="width:1300px; border:1px solid green">
                <ul>
                    <li>이달의 혜택</li>
                </ul>
            </div>
        </li>
        <li onmouseover="showSubcategory(2);" onmouseout="hideSubcategory();">
            이용가이드&nbsp;&nbsp;
            <div class="subcategory" style="width:1300px; border:1px solid green">
                <ul>
                    <li>운영/운휴</li>
                    <li>오시는 길</li>
                </ul>
            </div>
        </li>
        <li onmouseover="showSubcategory(3);" onmouseout="hideSubcategory();">
            소통서비스&nbsp;&nbsp;
            <div class="subcategory" style="width:1300px; border:1px solid green">
                <ul>
                    <li>공지사항</li>
                    <li>QnA</li>
                </ul>
            </div>
        </li>
    </ul>
</div>

</body>
</html>
