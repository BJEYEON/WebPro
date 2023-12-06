<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
    @keyframes fadeInUp {
        0% {opacity: 0;transform: translate3d(0, 100%, 0);}
        to {opacity: 1;transform: translateZ(0);}
    }
 	
   .operation_box_title{position:relative; animation:fadeInUp 2s;}
   .operation_date_box{position:relative; animation:fadeInUp 2s;}
   .operation_time_box{position:relative; animation:fadeInUp 2s;}
   .toto{ position: relative; animation: fadeInUp 4s;}
   #rest_box{ position: relative; animation: fadeInUp 4s;}
   .holidayBox{position:relative; animation:fadeInUp 2s;}
   
</style>

	<div class="operation_box">
		<div class="operation_box_title">
			<h2 style="text-align:center;">운영/운휴</h2>
		</div>
		<div class="operation_date_box">
				<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
				<h2 style="text-align:center;">
					<fmt:formatDate value="${now}"></fmt:formatDate>
				</h2>
		</div>
		
		<div class="operation_time_box">
			<div class="time_box_title">운영 시간</div>
			<div class="time_box_time"> 10:00 ~ 22:00 </div>
		</div>
		
		<br><br>
		<h2 class="toto" style="font-size:30px; text-align:center; line-height:100px;">오늘의 운휴시설</h2> 
		<div id="rest_box">
			<c:forEach var="AttractionVO" items="${aseqList}">
				<a href="attractionDetail?aseq=${AttractionVO.aseq}">
					<div id="att_list">
						<img src="images/attraction_images/${AttractionVO.image}"/>
						<h3 style="font-weight:400">${AttractionVO.atname}</h3>
					</div>
				</a>
			</c:forEach>
		</div>
	
		<div class="holidayBox">
      
			<p>기상상태에 따라 (0℃ 이하 또는 30℃ 이상, 7~14㎧ 이상의 풍속, 0.2㎜ 이상의 비가 내리는 경우)<br>
				매직아일랜드 일부 어트랙션 운행이 중단될 수 있습니다.</p>
			<p>기상상태와 별개로 현장 상황에 따라 예고 없이 운휴하거나 중간 점검을 할 수 있습니다</p>
		</div>
		<br><br>
	</div>


<%@ include file="../footer.jsp" %>