<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<style>
h2 {font-family:'IBM Plex Sans KR', sans-serif; font-size: 50px; text-align: center; padding-top: 40px;}
.image-box {text-align:center;}
.image-box img {}
.button-box {display: flex; justify-content: center; align-items: center;}
.submit{position:relative; font-size:20px; width:220px; height:56px; color: rgb(111, 35, 249); background:white; 
	font-weight:600; border-radius:28px; border:2px solid #6317ed; text-align:center; font-family:'IBM Plex Sans KR', sans-serif;}  
.location {display: flex;align-items: center;font-size: 20px;}
.location img {margin-right: 10px;}
</style>
<script>
  function goToNaverMap() {
	 window.open("http://naver.me/xItoPO6v", "_blank");
  }
</script>
<div class="page-title">
	<div class="container">
		<h3 style="font-family:'IBM Plex Sans KR', sans-serif; font-size: 50px; text-align:center;">오시는 길</h3>
	</div>
</div>
<div id="daumRoughmapContainer1688018805148" class="root_daum_roughmap root_daum_roughmap_landing" style="margin: 0 auto;"></div>

<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1688018805148",
		"key" : "2fcvr",
		"mapWidth" : "640",
		"mapHeight" : "360"
	}).render();
</script>



<br><br>
  <div class="button-box">
    <input type="button" value="네이버 지도 보러가기" class="submit" onClick="goToNaverMap()">
  </div><br><br><br>
        <div class="container">
            <table class="board-table" style="font-size:20px"> 
				<tr>
        			<td>
          				<div class="location">
            				<img src="images/loca.png">
            					<h4>롯데월드 어드벤처 (서울 송파구 올림픽로 240)</h4><br><br>
          				</div>
        			</td>
      			</tr>	
      		</table>
      	</div>

<br><br><br>
  

<%@ include file="../footer.jsp" %>
