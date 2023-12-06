<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div style="clear: both;"></div>
<article>
<form method="post" name="formm">
<div class="att_Detail_title">
   	<div id="att_Detail_text">모바일 ${AttractionVO.atname}</div>
   	<div id="att_Detail_exp">${AttractionVO.acontent}</div>
   	<div id="att_Detail_tag">
   		<ul>
   			<li>${AttractionVO.act1}</li>
   			<li>${AttractionVO.act2}</li>
   		</ul>
   	</div>
</div>
<div id="att_Detail_img_tool">
	<img id="att_Detail_img" src="images/attraction_images/${AttractionVO.image}"/>
</div>
<div id="att_Info_back">
	<div id="att_Info_box_tool">
		<div class="att_Info_box">
			<div class="att_Info_icon"><img src="images/icons/rideInfo_card_icon3.png"/></div>
			<div class="att_Info_text">탑승인원</div>
			<div id="att_Info_pnum">${AttractionVO.pnum}명</div>
		</div>
		<div class="att_Info_box">
			<div class="att_Info_icon"><img src="images/icons/rideInfo_card_icon4.png"/></div>
			<div class="att_Info_text">이용정보</div>
			<div id="att_Info_limit">
				${AttractionVO.limitkey}<br>
				${AttractionVO.limitage}
			</div>
		</div>
	</div>
	<p id="att_Info_text2">탑승제한</p>
	<div id="att_Info_bottom"><br>
		<div id="att_Info_bottom_tool">	
			<div id="att_Info_icon_tool">
				<div id="att_Info_icon2"><img src="images/icons/rideInfo_rest_icon1.png"></div>
				<div id="att_Info_icon_text2">음주</div>
			</div>
			<div id="att_Info_icon_tool">
				<div id="att_Info_icon2"><img src="images/icons/rideInfo_rest_icon2.png"></div>
				<div id="att_Info_icon_text2">임산부</div>
			</div>
			<div id="att_Info_icon_tool">
				<div id="att_Info_icon2"><img src="images/icons/rideInfo_rest_icon3.png"></div>
				<div id="att_Info_icon_text2">심/혈관계 질환자</div>
			</div>
			<div id="att_Info_icon_tool">
				<div id="att_Info_icon2"><img src="images/icons/rideInfo_rest_icon4.png"></div>
				<div id="att_Info_icon_text2">디스크 환자</div>
			</div>
		</div>
	</div>
</div><br>
<p id="att_Info_text2">운휴일정</p>
<div class="closeInfo">
	<div class="att_holiday_tool">
		<p class="att_holiday_txt">
			<span>${AttractionVO.aresult}</span>
		</p>
	</div>
	<p class="txt">
		<span style="color:#550adf;"> ※ 금일 기준으로부터 7일동안의 운휴정보입니다.</span>
		<br>
		※ 기상 변화 및 파크 상황에 따라 운휴 일정이 변경될 수 있습니다.
	</p>
	<p class="link">
		<a href="guide" class="grayBtn">이번 달 운휴 달력 보러가기</a>
	</p>
	<div class="btnArea">
		<a href="/attractionForm" class="purpleBtn">목록</a>
	</div>
</div>
</form>
</article>
<%@ include file="../footer.jsp" %>