<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${writeResult eq SUCCESS }">
		<script>alert('글쓰기성공');</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>alert('글쓰기실패'); history.back();</script>
	</c:if>
	<c:if test="${modifyResult eq SUCCESS }">
		<script>alert('${param.bid}번글 수정 성공');</script>
	</c:if>
	<c:if test="${modifyResult eq FAIL }">
		<script>alert('${param.bid}번글 수정 실패'); history.back();</script>
	</c:if>
	<c:if test="${not empty deleteMsg }">
		<script>alert('${deleteMsg}');</script>
	</c:if>
	<c:if test="${replyResult eq SUCCESS }">
		<script>alert('${param.bid}번글에 대한 답글쓰기실패'); history.back();</script>
	</c:if>
	<c:if test="${replyResult eq FAIL }">
		<script>alert('${param.bid}번글에 대한 답글쓰기실패'); history.back();</script>
	</c:if>
	<table>
		<caption>게시판</caption>
		<tr><td><a href="${conPath }/writeView.do">글쓰기</a></td></tr>
	</table>
	<table>
		<tr>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>IP</th><th>작성</th><th>조회수</th>
		</tr>
		<c:if test="${list.size() eq 0 }"> <!-- list->request.setAttribute("list", bDao.listboBoard(startRow, endRow)); //글목록 뷰페이지(list.do)로 전달 -->
			<tr><td colspan="6">해당페이지 글이 없습니다</td></tr>
		</c:if>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.bid }</td>
				<td>${dto.bname }</td>
				<td class="left">
					<!-- bindent만큼 들여쓰기(답변글) -->
					<c:forEach var="i" begin="1" end="${dto.bindent }">
						<c:if test="${i eq dto.bindent }">
							└
						</c:if>
						<c:if test="${i != dto.bindent }">
							&nbsp; &nbsp; &nbsp;
						</c:if>
					</c:forEach>
					<a href="${conPath }/content.do?bid=${dto.bid}&pageNum=${pageNum}">
						${dto.btitle }
					</a>
					<c:if test="${dto.bhit > 10 }">
						<b>( * )</b>
					</c:if>
				</td>
				<td>${dto.bip }</td>
				<td>
					<fmt:formatDate value="${dto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
				</td>
				<td>${dto.bhit }</td>
			</tr>
		</c:forEach>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/list.do?pageNum=${startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b>${i }</b>]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/list.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/list.do?pageNum=${endPage+1}">다음</a>]
		</c:if>
	</div>
</body>
</html>