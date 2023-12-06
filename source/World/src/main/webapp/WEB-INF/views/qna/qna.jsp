<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
.answer {display: none;}

</style>

<script>
function toggleAnswer(answerId) {
    var answer = document.getElementById(answerId);
    var allAnswers = document.getElementsByClassName("answer");

    for (var i = 0; i < allAnswers.length; i++) {
        if (allAnswers[i].id !== answerId) {
            allAnswers[i].style.display = "none";
        }
    }

    if (answer.style.display === "none") {
        answer.style.display = "table-row";
    } else {
        answer.style.display = "none";
    }
}
</script>


<article>
<div class="page-title" style="text-align:center;">
	<div class="container">
		<h3 style="font-family:'IBM Plex Sans KR', sans-serif; font-size: 50px;">QnA</h3>
	</div>
</div>
<div style="position: relative; text-align: center;">
  <img src="images/qna_image.jpg" style="opacity: 0.5;">
  <div style="position: absolute; top: 35%; left: 50%; transform: translate(-50%, -50%);">
    <p style="font-size: 24px; color: white;">
    <h3 style="font-family:'IBM Plex Sans KR', sans-serif; font-size: 30px; padding-top: 50px;"> 더 궁금하신 사항이 있으면 <br>이용문의를 이용하시기 바랍니다.</h3>
	<div id="buttons" style="float:center">
		<input type="button" value="이용문의" class="submit" onclick="location.href='qnaList?first=y'" 
			style="display:inline-block; font-size: 18px; font-weight:400; font-family:'IBM Plex Sans KR', sans-serif; background: #CCFF99; 
			border: 2px solid #fff; border-radius: 30px; padding: 14px 58px; margin-top: 40px;">
	</div>

  </div>
 <br><br><br>
 <div id="board-search">
        <div class="container">
            <div class="search-window"> 
 		
			</div>
		</div>
</div>
<br>
	<div id="qna_category_top_menu">	
		<a href="">전체</a>&nbsp;&nbsp;&nbsp;
		<a href="">이용정보</a>&nbsp;&nbsp;&nbsp;
		<a href="">우대정보/이벤트</a>&nbsp;&nbsp;&nbsp;
		<a href="">연간이용</a>&nbsp;&nbsp;&nbsp;
		<a href="">온라인예매</a>&nbsp;&nbsp;&nbsp;
		<a href="">장애인 탑승예약제</a>&nbsp;&nbsp;&nbsp;
		<a href="">기타</a>&nbsp;&nbsp;&nbsp;
	</div>		
</div><br><br>
<div id="board-list">
        <div class="container">
            <table class="board-table" style="font-size:20px; width:960px; margin:0 auto;">  
                <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th><a href="#!" onclick="toggleAnswer('answer1')"> 매직패스 사전예매는 어떻게 하나요? </a></th>      
                </tr>   
                <tr id="answer1" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">매직패스 프리미엄 사전 예매는 롯데월드 앱에서만 가능하며<br>
매일 자정, 당일을 포함한 3일간의 예매가 가능합니다.<br>
또한 한정수량 상품임을 고려하여 1인당 최대 4매까지만 구매가 가능하며,<br>
온라인 사전 예매 시 예약일 기준 3일 이내 재구매가 불가능합니다.<br><br>
매직패스 프리미엄 사전 예매 수량 변경을 원하시면 취소 이후 재구매 하셔야 합니다.<br>
단, 예매 취소 시 매직패스 프리미엄 수량이 남아있지 않을 수 있으며,<br>
당일 예매의 경우 예약 1시간 이후부터 취소 위약금 100%가 발생합니다.<br><br>
※ 매직패스 프리미엄은 실사용 목적을 위한 구매를 우선으로 하며, 비정상적인 방법으로의 구매,<br>
   과도한 매수의 구매, 반복적인 구매 및 취소 행위, 재판매 행위 시 구매가 제한될 수 있습니다.<br>
                	
                	</th>
           		</tr>
                <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th><a href="#!" onclick="toggleAnswer('answer2')"> 어드벤처를 나갔다가 다시 들어올 수 있나요? </a></th>             
                </tr>
                <tr id="answer2" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">롯데월드 어드벤처에서는 파크 입장 후 퇴장하시면 원칙적으로 재입장이 불가능합니다.<br><br>
단, 재입장을 도와드리는 몇가지 사항에 대해 안내해 드립니다.<br><br>
  ① 아이스링크 이용 손님<br><br>
  ② 저자거리 또는 민속박물관 이용 손님(어드벤처 3F 민속관게이트 이용)<br><br>
  ③ 의무실 방문 후 간호사 진단에 따라 외부 의료기관 방문하는 경우<br><br>
  ④ 파크 입장 후 매직패스 프리미엄 티켓 구매를 희망하시는 경우<br>
                  <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th><a href="#!" onclick="toggleAnswer('answer3')"> 공연에 대해 궁금한 것은 어디에 물어보나요?</a></th>  
                </tr>
                  <tr id="answer3" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">공연 및 공연참여와 관련된 질문은 공연참여사무실로 연락주시면 안내 및 상담이 가능합니다.<br><br>
※ 공연참여사무실 : 02-411-4339(운영시간 12:00~20:00)<br><br>
현재 롯데월드에서 진행중인 공연 정보가 궁금하시다면,<br><br>
홈페이지 즐길거리-공연-금주의공연 메뉴를 통해서 자세한 공연의 정보와 공연 스케줄을 확인하실 수 있습니다.   <br>     	
                  <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th><a href="#!" onclick="toggleAnswer('answer4')"> 어린이, 청소년이 어른티켓으로 이용할 수 있나요? </a></th>
              </tr> 
              <tr id="answer4" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">어린이(36개월이상~만 12세), 청소년(만 13세~만 18세) 손님은 어른(만 19세 이상)티켓 사용이 가능합니다.<br><br>
참고로, 만 36개월 미만인 유아손님의 경우 무료입장이 가능하니 참고부탁드립니다.<br>
※ 단, 유아용 어트랙션 탑승 시 베이비 티켓 구매 필요(0~12개월 미만의 경우 어트랙션 무료이용 가능)   
                <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th>
                      <a href="#!" onclick="toggleAnswer('answer5')" >티켓의 QR코드를 캡쳐해서 이용 가능한가요?</a>                     
                    </th>                
                </tr>
                <tr id="answer5" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">캡쳐 된 티켓의 QR코드는 입장 및 매직패스 사용이 어렵습니다.<br><br>
다른 분께 티켓을 보내실 경우 마이티켓에서 보내고자 하는 티켓의 '선물하기' 버튼을 활용해 티켓을 전송해주시기 바랍니다.<br><br>
'선물하기' 기능과 관련된 FAQ를 검색해주세요!<br>
                <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th><a href="#!" onclick="toggleAnswer('answer6')">홈페이지 로그인이 되지 않아요</a></th>                   
                </tr>
                <tr id="answer6" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">1. 로그인이 되지 않을 때 쿠키설정을 확인해주시기 바랍니다.<br><br>
    인터넷 익스플로러 브라우저 사용 시 '쿠키 처리 방식'이 '허용'으로 되어 있어야 로그인이 가능합니다.<br><br>
    ※확인 방법 : 인터넷 옵션 → 개인정보 → 고급 → 현재 사이트의 쿠키/링크된 사이트의 쿠키 설정 '허용'<br><br><br>
2. 팝업 차단이 되어 있을 경우 로그인창이 뜨지 않을 수 있습니다.<br><br>
    팝업 설정을 '허용'으로 변경해주시기 바랍니다.<br><br>
    ※확인 방법 : 인터넷 옵션 → 개인정보 → '팝업 차단 사용' 체크박스 해지<br>
                <tr>
                    <td><img src=images/Q.jpg style="width: 60px; height: 55px; border-radius: 50%; border:1px solid blue"></td>
                    <th><a href="#!" onclick="toggleAnswer('answer7')">롯데월드에서 사용가능한 상품권은 뭐가있나요?</a></th>                   
                </tr>
                 <tr id="answer7" class="answer">
               		 <td></td>
                	<th style="font-size:18px; font-weight:normal">롯데월드 어드벤처에서 사용 가능한 상품권은 총 3가지 입니다.<br><br>
- 롯데백화점 상품권<br><br>
- 롯데호텔 상품권(※ 뒷면 사용처 확인 필수)<br><br>
- 국민관광 상품권<br><br><br>
※ 롯데백화점 식품관 전용 상품권은 사용이 불가합니다.<br><br>
※ 롯데호텔 상품권 사용처에는 LOTTEWORLD ADVENTURE 또는 롯데월드 어드벤처가 기재되어 있어야 합니다.<br><br>
    - 사용장소에 '월드'라고 기재되어 있는 것은 롯데호텔월드 지점을 뜻하며, 어드벤처는 사용이 불가합니다.<br><br>
※ 롯데백화점 모바일 상품권은 어드벤처 내 식음매장 및 상품매장에서 사용이 불가합니다.<br>
                <tr>
            </table>
        </div>
    </div>


</article>
<br><br><br>


<%@ include file="../footer.jsp" %>
    