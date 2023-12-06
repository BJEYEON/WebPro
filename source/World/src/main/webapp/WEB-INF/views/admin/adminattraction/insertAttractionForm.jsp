<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp" %>  

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

$(function(){
    $('#myButton').click(function(){
        var formselect = $("#fileupForm")[0]; 
        var formdata = new FormData(formselect);

        // kind 값을 설정
         var kindValue = "attraction"; // 원하는 값으로 설정 

        // FormData에 kind 값을 추가
        formdata.append("kind", kindValue);

        $.ajax({
            url: "<%=request.getContextPath() %>/fileupat",
            type: "POST",
            enctype: "multipart/form-data",
            async: false,
            data: formdata,
            timeout: 10000,
            contentType: false,
            processData: false,
            
            success: function(data){
                if(data.STATUS == 1){
                    $("#filename").append("<div>" + data.FILENAME + "</div>");
                    $("#image").val(data.FILENAME);
                    $("#filename").append("<img src='images/attraction_images/" + data.FILENAME + "' height='150'/>");
                }
            },
            error: function(){
                alert("실패");
            }
        });
    });
});

</script>
<article>
<div class="findfindd">
<div class="id_foundd">
<h1>어트랙션 추가</h1>
<br><hr><br>  
<form name="insertat" action="insertAttraction" method="post">
	<table class="baba">
		<tr>
			<th>어트랙션 이름</th>
			<td><input type="text" name="atname" size="47"></td>
		</tr>
		<tr>
			<th>어트랙션 설명</th>
			<td><input type="text" name="acontent" size="47"></td>
		</tr>
		<tr>
			<th>태그1</th>
			<td><input type="text" name="act1" size="47"></td>
		</tr>
		<tr>
			<th>태그2</th>
			<td><input type="text" name="act2" size="47"></td>
		</tr>
		<tr>
			<th>탑승인원(숫자)</th>
			<td><input type="text" name="pnum" size="47"></td>
		</tr>
		<tr>
			<th>제한사항1(키)</th>
			<td><input type="text" name="limitkey" size="47"></td>
		</tr>
		<tr>
			<th>제한사항2(나이)</th> 
			<td><input type="text" name="limitage" size="47"></td>
		</tr>
		<tr>
			<th>베스트 어트랙션<br>(Y/N)</th>
			<td>
				<input type="radio" style="width:17px;height:17px;border:1px;" name="bestat" value="Y">사용
				<input type="radio" style="width:17px;height:17px;border:1px;" name="bestat" value="N">미사용	
			</td>
		</tr>
		<tr>
			<th>운휴정보<br>(Y/N)</th> 
			<td>
				<input type="radio" style="width:17px;height:17px;border:1px;" name="aresult" value="Y">사용
				<input type="radio" style="width:17px;height:17px;border:1px;" name="aresult" value="N">미사용
			</td>	
		</tr>
		<tr style="height:250px">
			<th>어트랙션 이미지</th>
	    	<td>
	   			<input type="hidden" name="image" id="image" >
	   			<div id="filename"></div>
	   		</td>
	   	</tr>
	</table>
</form>
<div class="fileUp">
	<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
		<input type="file" name="fileimage" id="mymy">
		<input type="button" id="myButton" value="추가">
	</form>
</div>
<div class="update_buttons">
	<input type="button" value="기구등록" onclick="go_insertat()">
	<input type="button" value="목록으로" onclick="go_mov('adminAttraction')">
</div> 
</div>
</div>
</article>
	
<%@ include file ="../footer.jsp"%>