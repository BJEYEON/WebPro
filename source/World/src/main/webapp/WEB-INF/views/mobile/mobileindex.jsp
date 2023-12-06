<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script type=text/javaScript>
    $(function(){
    	var num=0;
    	setInterval(function(){
            	$('#imgs').animate({ left : num * -1355 },2000);
            num++;
        	if(num==Number('${size}'))num=0;
        }, 4000);
    });
</script>

<style>
    @keyframes fadeInUp {
        0% {opacity: 0;transform: translate3d(0, 100%, 0);}
        to {opacity: 1;transform: translateZ(0);}
    }
 	.mainTit{ position: relative;animation: fadeInUp 3s;}
    .mainTxt{ position: relative; animation: fadeInUp 4s;}
    #mainTodayArea{ position: relative; animation: fadeInUp 2s;}
    .boxArea{ position: relative; animation: fadeInUp 5s;}
	#mainback{ position: relative; animation: fadeInUp 7s;}
    .main_bottom{ position: relative; animation: fadeInUp 7s;}
</style>



<div id = "main_img">
	<div id = "view" style="position:relative; width:1350px; overflow:hidden; height:506px; border-radius:20px;">
		<div id ="imgs" style="position:absolute; width:11000px; text-align:left;">
			<c:forEach items="${bannerList}" var="bannerVO">
				<img src="images/banner/${bannerVO.image}" style="width:1350px; object-fit: fill; margin:0">
			</c:forEach>
		</div>
	</div>
</div>


<div id="mainTodayArea" >
	<a href="guide">
 		<img src="images/icons/mainTodayArea_tit_icon.png"/>&nbsp;&nbsp;&nbsp;오늘의 파크 운영시간&nbsp;&nbsp;10:00 ~ 21:00
	</a>
	<br><h2>모바일 버전입니다</h2>
</div>

					<!--  절취선  -->	
<br>
<div class="mainbox">                                         <!-- 제일 큰 상자 -->
	<div class="mainCon mainCon1"><!-- 나에게 꼭 맞는 혜택 -->     <!-- 첫번째 상자  -->
		<p class="mainTit"><span style="font-weight:bold">자신에게 맞는 혜택</span> 알아볼까요?</p>	
		<p class="mainTxt">현재 진행 중인 할인혜택을 알아보세요.</p>
		 <!-- 두번째 상자 -->
		<div class="boxArea">                               <!-- 세번째상자 -->
			<div class="box-tr">
				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/card.png" width="248" height="198"/></span>
						<span class="price1">월드카드로 최대 10만원 캐시백 혜택 챙겨요! 40000원</span>		
					</a>
				</div>
						
				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/point.jpg" width="248" height="198"/></span>
						<span class="price1">월드 최대 30% 할인 + 이용금액 100% 캐시백까지</span>
					</a>
				</div>

				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/npay.jpg" width="248" height="198"/></span>
						<span class="price1">가정의달은, 꼭 네이버페이로 39,900원</span>
					</a>
				</div>

				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/family.jpg" width="248" height="198"/></span>
						<span class="price1">패밀리 패키지(어른+어린이) 70,000원</span>
					</a>
				</div>
			
			</div>
				
			<div class="box-tr">
				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/friend.png" width="248" height="198"/></span>
						<span class="price1">프랜드 패키지(어른+어른) 90,000원</span>
					</a>
				</div>

				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/fastfast.jpg" width="248" height="198"/></span>
						<span class="price1">패스트패스 100,000원</span>
					</a>
				</div>

				<div class="box-td">
					<a href="event01">
				 		<span class="imggg"><img src="images/springspring.jpg" width="248" height="198"/></span>
						<span class="price1">스프링데이 30,000원</span>			
					</a>
				</div>

				<div class="box-td">
					<a href="event01">
						<span class="imggg"><img src="images/76419_59366_5741.jpg" width="248" height="198"/></span>
						<span class="price1">교복 패키지 50,000원</span>
					</a>
				</div>
			</div>
		</div>
     </div>
</div>

<!--  main3  -->

<div id="mainback">
	<div id="maintitle">재미있고 즐거운&nbsp;<span style="font-weight:bold;">다양한 어트랙션!</span></div>
	<div class="tag">
		<ul>
			<li>아이와 함께</li>
			<li>야외에서 신나게</li>
			<li>실내에서 쾌적하게</li>
		</ul>
	</div>
	<h2 style="font-size:30px; text-align:center; line-height:80px;">인기 어트랙션</h2>
	<div id="mainimg">
		<c:forEach var="AttractionVO" items="${bestList}" begin="0" end="2">
			<a href="attractionDetail?aseq=${AttractionVO.aseq}">
				<div id="att_list">
					<img src="images/attraction_images/${AttractionVO.image}"/>
					<h3 style="font-weight:400">${AttractionVO.atname}</h3>
				</div>
			</a>
		</c:forEach>
	</div>
	<div class="tag">
	<ul>
		<li><a href='attractionForm'>더 많은 어트랙션 보기</a></li>
		<li><a href='guide'>운휴 정보 보러 가기</a></li>
	</ul>
</div>
</div>

<!--  절취선  -->
<div class="main_bottom">
	<div id="line">
		<h1>What's New</h1>
	</div>  
	<h3>꿈과 환상의 나라로 어서오세요!</h3>
	<div id="main_view_">              
		<div id="parade">
		   <a href="parade">
		        <div class="scale">
		        	<img src="images/parade1.jpg" width="250" height="170" >
		        </div>
		        <div class="title">카니발 판타지 퍼레이드</div>
		    </a>
		</div>       
		<div id="parade">
		   <a href="parade">
		        <div class="scale"><img src="images/parade2.jpg" width="250" height="170" ></div>
		        <div class="title">레니의 대모험~<br>드래곤 성을 찾아서~</div>
		    </a>
		</div>       
		<div id="parade">
		   <a href="parade">
		        <div class="scale"><img src="images/parade3.jpg" width="250" height="170" ></div>
		        <div class="title">문라이트 퍼레이드</div>
		    </a>
		</div>       
		<div id="parade">
		   <a href="parade">
		        <div class="scale"><img src="images/parade4.jpg" width="250" height="170" ></div>
		        <div class="title">타임 오디세이</div>
		    </a>
		</div> 
	</div>      
</div>
<%@ include file="footer.jsp" %>