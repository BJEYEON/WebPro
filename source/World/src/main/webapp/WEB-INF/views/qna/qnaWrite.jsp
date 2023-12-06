<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- <script type =text/javascript>

function go_insertQna(){
	var chkBox = document.getElementsByName("check");
	//var pass = document.getElementById("pass");
	if(document.qna.title.value=""){
		alert("제목을 입력해주세요");
		document.qna.title.focus();
		return;
	}else if(document.qna.content.value=""){
		alert("문의 내용을 입력해주세요");
		document.qna.content.focus();
		return;	
	}
	if( chkBox.checked ){
		if(document.qna.pass.value=""){
			alert("비밀번호를 입력해주세요");
			document.qna.pass.focus();
			return;
		}
	} 
	document.qna.action="qnaWrite";
	document.qna.submit();	
}
</script>
  -->

 
<article>
<div class="qna">
	<div class="qnaimg" style="background-image:url('images/qnaaa.png');"></div>
	<div class="qnaBox">
		<h2> 1:1 고객 게시판 </h2>
		<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>

		<form class="fix02" name="qna" method="post">
			<input type="hidden" name="command" value="qnaWrite">

	    	<table class="fix03">
	    		<tr>
	    			<th>Secret mode</th>
	    			<td>	
	    				<input type="checkbox" name="check" value="secret" onchange="enabled()">
    						&nbsp;비밀글로 하기&nbsp;&nbsp;
    					<input type="password" name="pass" id="pass" size="15" 
    					 style= "background: lightgray;" disabled="disabled" >
					</td>
	    		</tr>
				<tr>
					<th>제목</th>
					<td width="500" style="text-align:left;">
						<input type="text" name="title" size="50" >
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td align="left" style="text-align:left;font-size:115%;">
						<textarea rows="8" cols="52" name="content" ></textarea>
					</td>
				</tr>
			</table>
		</form>
		<br>
		<div class="buttons">
			<input type="button" value="글쓰기" class="purpleBtn" style="border:none;" 
				onclick="go_insertQna()"> 
			<input type="reset" value="취소" class="purpleBtn" style="border:none;"  
				onclick="location.href='qnaList'">
		</div>
		<br>
	</div>
</div>
</article>
<%@ include file="../footer.jsp" %>