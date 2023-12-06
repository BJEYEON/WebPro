<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<form name="frm" method="post">
<input type="hidden" name="lqseq" value="${qnaVO.lqseq}">
<div class="qna">
	<div class="qnaimg" style="background-image:url('images/qnaaa.png');"></div>
	<div class="qnaBox">
		<h2> QnA 게시판 </h2>
		<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
		<div class="fix02">
			<table class="fix03">
				<tr>
					<th>제목</th>
					<td>${qnaVO.title}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
				</tr>
				<tr>
					<th>질문내용</th>
					<td>${qnaVO.content}</td>
				</tr>
				<tr>
					<c:choose>          
						<c:when test='${qnaVO.rep=="N"}'> <!-- 관리자 답변 전 표시 -->		
			    			<th>답변내용</th>
			    			<td colspan="2"><textarea name="reply" rows="2" cols="45"></textarea>
						</c:when>
						<c:otherwise>  <!-- 관리자 답변 후 표시 -->
							<th>답변내용</th>
							<td align="left" style="text-align:left;">
							<pre>${qnaVO.reply}</pre>
						</c:otherwise>
					</c:choose>	
				</tr>	
			</table>
		</div>
		<br>
		<div class="buttons" style="height:70px;" >
			<c:choose>
				<c:when test='${qnaVO.rep=="N" }'>
					<input type="button" style="padding :0;" class="purpleBtn" value="저장" onClick="go_rep()">
					<input type="button" style="padding :0;" value="목록보기" class="purpleBtn" onclick="location.href='/adminQna'">
				</c:when>
				<c:otherwise>
					<input type="button" style="padding :0;" value="목록보기" class="purpleBtn" onclick="location.href='/adminQna'">
				</c:otherwise>
			</c:choose>
		</div>
		<br>
	</div>
</div>
</form>
</article>
<%@ include file="../footer.jsp" %>