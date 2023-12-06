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
			url:"<%=request.getContextPath() %>/fileupno",    // 현재주소의 fileup 리퀘스트로 요청  http://localhost:8070/fileup
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
	            	$("#filename").append("<img src='images/notice_images/"+data.FILENAME+"' height='150'/>");
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
<h1>공지사항 수정</h1>
<br><hr><br>  
<form name="frm" method="post">
	<input type="hidden" name="nseq" value="${noticeVO.nseq}">
 	<input type="hidden" name="oldfilename" value="${noticeVO.ncontent}">
	<table class= "baba" >
		<tr>
			<th>관리자 아이디</th> 
			<td><input type="text" name="id" size="47" value="${noticeVO.id}"></td>
		</tr>
		<tr>
			<th>제목</th> 
			<td><input type="text" name="title" size="47" value="${noticeVO.title}"></td>
		</tr>
		<tr style="height:250px">
			<th>내용</th>
	    	<td>
	    		현재이미지<br>
	    		<img src="images/notice_images/${noticeVO.ncontent}" width="400px">
	   			<input type="hidden" name="ncontent" id="image">
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
	<input type="button" value="수정" onclick="go_mod_savent()">
	<input type="reset" value="취소" onClick="location.href='adminNotice'"> 
</div>
</div>
</div>
</article>
<%@ include file ="../footer.jsp"%>