<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#myButton').click( function(){
		
		var formselect = $("#fileupForm")[0]; 
		var formdata = new FormData(formselect);   
		
		$.ajax({    
			url:"<%=request.getContextPath() %>/fileupat",    // 현재주소의 fileup 리퀘스트로 요청  http://localhost:8070/fileup
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
	            	$("#filename").append("<img src='images/attraction_images/"+data.FILENAME+"' height='150'/>");
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
<h1>어트랙션 수정</h1>
<br><hr><br>  
<form name="updateat" method="post">
	<input type="hidden" name="aseq" value="${AttractionVO.aseq}">
 	<input type="hidden" name="oldImage" value="${AttractionVO.image}">
	<table class="baba">
		<tr>
			<th>어트랙션 이름</th> 
			<td><input type="text" name="atname" size="47" value="${AttractionVO.atname }"></td>
		</tr>
		<tr>
			<th>어트랙션 설명</th> 
			<td><input type="text" name="acontent" size="47" value="${AttractionVO.acontent }" ></td>
		</tr>
		<tr>
			<th>태그1</th> 
			<td><input type="text" name="act1" size="47" value="${AttractionVO.act1 }"></td>
		</tr>
		<tr>
			<th>태그2</th> 
			<td><input type="text" name="act2" size="47" value="${AttractionVO.act2 }"></td>
		</tr>
		<tr>
			<th>탑승인원(숫자)</th> 
			<td><input type="text" name="pnum" size="47" value="${AttractionVO.pnum }"></td>
		</tr>
		<tr>
			<th>제한사항1(키)</th> 
			<td>
			<input type="text" name="limitkey" size="47" value="${AttractionVO.limitkey }"></td>
		</tr>
		<tr>
			<th>제한사항2(나이)</th> 
			<td><input type="text" name="limitage" size="47" value="${AttractionVO.limitage }"></td>
		</tr>
		<tr>
			<th>베스트 어트랙션<br>(Y/N)</th>
			<td>
				<c:choose>
		  			<c:when test='${AttractionVO.bestat=="Y"}'>
		  				<input type="radio" style="width:17px;height:17px;border:1px;" name="bestat" value="Y" checked="checked">사용
		  				<input type="radio" style="width:17px;height:17px;border:1px;" name="bestat" value="N">미사용
		  			</c:when>
					<c:otherwise>
						<input type="radio" style="width:17px;height:17px;border:1px;" name="bestat" value="Y">사용
						<input type="radio" style="width:17px;height:17px;border:1px;" name="bestat" value="N" checked="checked">미사용
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>운휴 정보<br>(Y/N)</th>
			<td>	
				<c:choose>
				 	<c:when test='${AttractionVO.aresult=="Y"}'>
				 		<input type="radio" style="width:17px;height:17px;border:1px;" name="aresult" value="Y" checked="checked">사용
						<input type="radio" style="width:17px;height:17px;border:1px;" name="aresult" value="N">미사용
				  	</c:when>
					<c:otherwise>
						<input type="radio" style="width:17px;height:17px;border:1px;" name="aresult" value="Y">사용
						<input type="radio" style="width:17px;height:17px;border:1px;" name="aresult" value="N" checked="checked">미사용
					</c:otherwise>
				</c:choose>	
			</td>
		</tr>
		<tr style="height:250px">
			<th>어트랙션 이미지</th>
	    	<td>
	    		현재이미지<br>
	    		<img src="images/attraction_images/${AttractionVO.image}" width="400px"><br>
	   			<input type="hidden" name="image" id="image" >
	   			<div id="filename"></div>
	   		</td>
	   	</tr>
	</table>
</form>
<div class="fileUp">
	<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
		<input type="file" name="fileimage"id="mymy">
		<input type="button" id="myButton" value="추가">
	</form>
</div>
<div class="update_buttons">
	<input type="button" value="수정" onclick="go_mod_saveat()">
	<input type="reset" value="취소" onclick="location.href='adminattractionDetail?aseq=${AttractionVO.aseq}'"> 
</div>
</div>
</div>
</article>
<%@ include file ="../footer.jsp"%>