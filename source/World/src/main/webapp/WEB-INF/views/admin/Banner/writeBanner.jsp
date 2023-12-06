<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- ajax -->
<script type="text/javascript">

$(function(){
	$('#myButton').click( function(){
		
		var formselect = $("#fileupForm")[0]; 
		var formdata = new FormData(formselect); 
		var kindValue = "banner"; 
        
        formdata.append("kind", kindValue);
		
		$.ajax({    
			url:"<%=request.getContextPath() %>/fileupba",    // 현재주소의 fileup 리퀘스트로 요청  http://localhost:8070/fileup
			type:"POST",
			enctype:"multipart/form-data",
			async: false, 
			data: formdata,
	    	timeout: 10000,
	    	contentType : false,
	        processData : false,
	        
	        success : function(data){ 
	            if( data.STATUS == 1 ){
	            	$("#filename").append("<div>"+data.FILENAME+"</div>");
	            	$("#image").val(data.FILENAME);
	            	$("#filename").append("<img src='images/banner/"+data.FILENAME+"' height='150'/>");
	            }
	        },
	        error: function() {				alert("실패");			}
		});
	
	});
});
</script>

<article>
<div class="findfindd">
<div class="id_foundd">
<h1>배너 등록</h1>  
<br><hr><br>
<form name="frm" method="post">
	<table class="baba">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" size="47"></td>
		</tr>
		<tr>
			<th>순위</th> 
			<td>
				<select name="order_seq" class="pl">
					<option value="">디스플레이될 순서를 선택하세요 </option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">사용안함 </option>
				</select>
			</td>
		</tr>
		<tr style="height:250px">
			<th>배너 이미지</th>
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
	<input type="submit" value="등록" onClick="go_insertBanner()">
	<input type="reset" value="취소" onClick="go_mov('adminBannerList')">
</div>
</div>
</div>
</article>
<%@ include file="../footer.jsp" %>
	
