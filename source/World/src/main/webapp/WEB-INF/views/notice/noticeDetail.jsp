<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<div class="event01">
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
	   		<input type="button" value="목 록" class="btn" onclick="location.href='notice'">
		</div>
	</div>
</div>
</article>
<%@ include file="../footer.jsp" %>