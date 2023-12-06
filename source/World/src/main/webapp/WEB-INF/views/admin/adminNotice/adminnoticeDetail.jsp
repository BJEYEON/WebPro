<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp"%>   
<article>
<div class="event01">
<form name="frm" method="post">
	<div class="event02">공지사항</div>
    <div class="event03">
		<div class="event04">공지</div>
		<div class="event05">${noticeVO.title}</div>
		<div class="event06"><fmt:formatDate value="${noticeVO.indate}" type="date"/></div>
	</div>
	<div class="event08">
		<img src="images/notice_images/${noticeVO.ncontent}" width="1150px"/>
	</div>
	<div class="event09">
		<div class="event10">
	   		<input type="button" value="목 록" class="btn" onclick="go_mov('adminNotice')">
	   		<input type="button" value="수 정" class="btn" onclick="go_modnt('${noticeVO.nseq}')">
	   		<input type="button" value="삭 제" class="btn" onclick="go_deletent('${noticeVO.nseq}')">
		</div>
	</div>
</form>
</div>
</article>

<%@ include file ="../footer.jsp"%>