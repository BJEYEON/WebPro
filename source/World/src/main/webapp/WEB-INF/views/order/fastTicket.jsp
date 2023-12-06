<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<link href="css/order.css" rel="stylesheet">  
<script src="script/order.js"></script>

<style>
	.container {position:relative; width:100%;} 
</style>

<article>
<form name="formm" method="post">
	<div class="order_box2">
		<div id="calendar"  class="calendar">
			<input type="hidden" id="calendar" name="visitdate">
		</div>
		<div class="order_box_select2">
			<div class="order_box_title">패스트패스 예매</div>
			<div class="order_box_date">
				<div class="order_box_date_text">방문일자/인원 선택</div>
				<div class="order_box_date_select" onclick="showCalendar()">
					<img src="images/ticket_images/calendar.png" style="width:40px; height:40px;">
				</div>
				<!-- 달력 선택 날짜 표기 -->
				<div id="calendarPopup" class="calendar-popup"></div>
				<div class="order_box_date_date">
					<input type="text"  id="selectedDate" name="visitdate2" >
				</div>
			</div>
			<!-- 수량 표시 -->
			<div class="order_quantity">
				<div class="order_quantity_text">
					<p style="font-weight:bold">어른</p>
					<p style="font-size:14px; color:gray;">만19세이상</p>
				</div>
				<div class="order_quantity_box">	
					<input type="text" name="p1" id="result" value="0" class="order_quantity_count">
				</div>
				<div class="order_quantity_box_button">	
					<button onclick="decrease(event, 'result')" class="order_quantity_count_button" style="border-right:1px solid black;">-</button>
					<button onclick="increase(event, 'result')" class="order_quantity_count_button">+</button>
				</div>
				<div class="quantityArg"></div>
				<div class="order_quantity_text">
					<p style="font-weight:bold">청소년</p>
					<p style="font-size:14px; color:gray;">만13세~만18세</p>
				</div>
				<div class="order_quantity_box">	
					<input type="text" name="p2" id="result2" value="0" class="order_quantity_count">
				</div>
				<div class="order_quantity_box_button">	
					<button onclick="decrease(event, 'result2')" class="order_quantity_count_button" style="border-right:1px solid black;">-</button>
					<button onclick="increase(event, 'result2')" class="order_quantity_count_button">+</button>
				</div>	
			</div>
			<!--  어트랙션 선택 -->
			<div class="check_wrapp">
				<c:forEach items="${aseqList}" var="attractionVO" >
					<div class="rect">
						<div class="check_btn">
							<input type="checkbox" value="${attractionVO.atname}" name="attraction" 
								class="check_btnbtn" onclick="count_check(this);"/>
						</div>
						<div class="check_atname">${attractionVO.atname}</div>
			            <img src="../../images/attraction_images/${attractionVO.image}" class="check_image"/>
			        </div>	
	         	</c:forEach>
			</div>
			<div id="reserve_buttons" class="order_box_button">
	       	<input type="button" value="구매하기" onClick="location.href='world.do?command=cartList'">
	        	<!--  <input type="button" value="장바구니" class="purpleButton" onclick="go_cart('1')"> -->
	       	</div>
			<!-- 안내 -->
			<div id="board-list">
		        <div class="container">
		            <table class="board-table" style="font-size:20px">  
		                <tr>
		                    <th><a href="#!" onclick="toggleAnswer('answer1')">취소/환불</a></th>      
		                </tr>   
		                <tr id="answer1" style="display:none">
		               		 
		                	<th style="font-size:15px; font-weight:normal;background:#F7F7F7;">
								<b>예매취소 안내</b> <br>
								<b>온라인 예매 시 선택한 날짜에만 방문 및 이용이 가능하며, 미사용시에 해당날짜가 지나면 자동 취소 됩니다.</b><br>
								(사용 후에는 취소가 불가능합니다.)<br>
								 - 본인+동반인 티켓 구매 후 동반인 티켓만 사용 시 본인 티켓 취소는 불가합니다. <br>
								 - 본인+동반인 티켓 구매 후 취소하실 경우 동반인 티켓을 먼저 취소하셔야합니다.<br>
								 - 시스템 자동 취소가 될 경우 제휴카드 실적은 은행영업일 기준 2~3일 후에 복구됩니다. <br> 
								 - 별도의 취소 수수료는 없으나 구매 후 환불요청 시 각 카드사에 따라 수수료를 차감합니다. <br>
								 - 예매취소를 원하시는 경우 [마이페이지 > 결제내역]에서 취소하실 수 있습니다. <br>
								 - 예매 후에는 반드시 마이티켓을 통하여 예매내역을 확인해 주시기 바랍니다. <br>
								</th>
		               	</tr>
		               	 <tr>
		                    <th><a href="#!" onclick="toggleAnswer('answer2')">이용안내</a></th>             
		                </tr>
		                <tr id="answer2" style="display:none">
		               		 
		                	<th style="font-size:15px; font-weight:normal; background:#F7F7F7">
								<b>이용 안내</b><br>
								<b> 1. 어드벤처 예매페이지 및 모바일APP을 통한 티켓예매 </b><br>
								<b> 2. 카카오 알림톡(또는 문자메시지)으로 웹티켓 URL 발송 </b><br>
								<b> 3. 웹티켓을 게이트에 제시 후 빠른 입장 </b><br>
								<br>
								※ 예매 후에는 반드시 마이티켓을 통하여 구매하신 웹티켓을 확인해주시기 바랍니다.<br>
								※ 티켓은 선택한 날짜에만 방문 및 이용 가능합니다.(다른 날짜에는 사용 불가)
							</th>					
					</table>
		       </div>
	       </div>
		</div>
	</div>
</form>
</article>
<%@ include file="../footer.jsp" %>>