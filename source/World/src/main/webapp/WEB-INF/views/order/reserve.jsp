<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="css/order.css" rel="stylesheet">
<script src="script/order.js"></script>
<article>
<div class="reserve">
	<div class="order_box">
		<div class="order_box_select">
			<div class="order_box_title">예매</div>
			<div class="order_box_text">
				<img src="images/ticket_images/reserve_imgs_free.png"/>
				<div class="order_box_text_content">★자유이용권★<br>
					<p style="line-height:23px; font-size:16px;">
						어른 53,000원<br>
						청소년 45,000원<br>
						어린이 30,000원<br>
					</p>
					<input type="button" value="예매하기" class="order_box_text_button" 
						onclick="location.href='/passTicket'">
				</div>
			</div>
			<div class="order_box_text">
				<img src="images/ticket_images/reserve_imgs_pass.png"/>
				<div class="order_box_text_content">★패스트패스★<br>
					<p style="line-height:23px; font-size:16px;">
						어른 110,000원<br>
						청소년 90,000원<br>
						어린이 70,000원<br>
					</p>
					<input type="button" value="예매하기" class="order_box_text_button" 
						onclick="location.href='/fastTicket' ">
				</div>
			</div>
		</div>
		<div class="order_box_content">
			<ul class="barList">
				<li>- 어드벤처/매직아일랜드 입장 및 놀이시설 이용(게임시설 등 유료시설 제외)</li>
				<li>- 민속박물관 관람(오후 7시 이전 입장)</li>
				<li>- 패스트 패스 이용시 예약시간 10분 전까지 입장</li>
			</ul>
		</div>
	</div>
	<div class="reserveBack">&nbsp;</div>
	<div class="bigBox1">
		<div class="bigBox5">
			<ul style="text-size:130%;">
				<h2>꼭 알아두세요.</h2>
				<li>
					<span style="font-weight:bold;">※ 연령에 따른 요금 적용 안내 (나이 확인이 가능한 신분증 또는 서류 제시)</span><br>
					&nbsp;&nbsp;&nbsp;1) 0~12개월 미만 : 파크 입장 및 유아 놀이시설(키즈토리아 등) 무료 이용<br>
					&nbsp;&nbsp;&nbsp;2) 12개월 이상 36개월 미만 : 파크 입장 무료(단, 단체 입장객 제외), 유아 놀이시설 이용은 유료로 이용 가능<br>
					&nbsp;&nbsp;&nbsp;⊙ 36개월 이상 ~ 만 12세 : 어린이 요금 적용<br>
					&nbsp;&nbsp;&nbsp;⊙ 만 13세 이상 ~ 만 18세 : 청소년 요금 적용(학교 및 학년 무관)<br>
					&nbsp;&nbsp;&nbsp;⊙ 만 65세 이상 : 어린이 요금 적용(기타 우대 적용불가)<br>
				</li>
				<li>
				<span style="font-weight:bold;">※ 유아놀이시설</span><br>
		        	&nbsp;&nbsp;&nbsp;⊙ 어드벤처 : 매직붕붕카, 햇님달님, 어린이 범퍼카, 로티트레인, 스윙팡팡, 유레카, 키즈토리아, 언더씨킹덤,드림보트<br>
					&nbsp;&nbsp;&nbsp;⊙ 매직아일랜드 : 머킹의 회전목마, 쁘띠빵빵
				</li>
			</ul>
		</div>
		<div class="bigBox6">
			<ul style="text-size:130%;">
				<h2>상시 우대 정보</h2>
				<li>
					<span style="font-weight:bold;">※ 장애인 우대</span><br>
					&nbsp;&nbsp;&nbsp;⊙ 대상 : 장애인증 등 공식증빙 지참 고객 + 동반 1인<br>
					&nbsp;&nbsp;&nbsp;⊙ 내용 : 종합이용권/파크이용권 50% 우대<br>
				</li>
				<li>
					<span style="font-weight:bold;">※ 국가유공자 우대</span><br>
					&nbsp;&nbsp;&nbsp;⊙ 대상 : 국가유공자증 등 공식증빙 지참 고객 + 동반1인<br>
					&nbsp;&nbsp;&nbsp;⊙ 내용 : 종합이용권/파크이용권 50% 우대<br>
				</li>
				<li>
					<span style="font-weight:bold;">※ 임산부 우대</span><br>
					&nbsp;&nbsp;&nbsp;⊙ 대상 : 모자수첩 등 공식증빙 지참 임산부 본인<br>
					&nbsp;&nbsp;&nbsp;⊙ 내용 : 종합이용권 50% 우대<br>
				</li>
				<li>
					<span style="font-weight:bold;">※ 다둥이 행복카드 우대</span><br>
					&nbsp;&nbsp;&nbsp;⊙ 대상 : 다둥이 행복카드 회원 가족 본인(카드에 명기된 가족에 한함)<br>
					&nbsp;&nbsp;&nbsp;⊙ 내용 : 종합이용권 30% 우대<br>
				</li>
			</ul>
		</div>
	</div>
</div>
</article>
<%@ include file="../footer.jsp" %>