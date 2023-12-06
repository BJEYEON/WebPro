<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<div class="qna">
	<div class="qnaimg" style="background-image:url('images/qnaaa.png');"></div>
	<div class="qnaBox">
		<h2>QnA 게시판</h2>
		<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
		<form class="fix02">
	    	<table class="fix03">
				<tr>
					<th>제목</th>
					<td width="500" style="text-align:left;">${qnaVO.title}</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td align="left" style="text-align:left;">
					<fmt:formatDate value="${qnaVO.indate}" type="date"/>
					</td>
				</tr>
				<tr>
					<th>질문내용</th>
					<td align="left" style="text-align:left;">${qnaVO.content}</td>
				</tr>
				<tr>
					<th>답변 내용</th>
					<td align="left" style="text-align:left;">${qnaVO.reply}</td>
				</tr>
			</table>
		</form>
		<br>
		<div class="buttons">
			<input type="button"  value="목록보기" class="purpleBtn" style="border:none;"
				onclick="location.href='qnaList'">
			<input type="button"  value="돌아가기"  class="purpleBtn" style="border:none;"
				onclick="location.href='qna'">
		</div>
		<br>
	</div>
</div>
</article>
<%@ include file="../footer.jsp" %> 