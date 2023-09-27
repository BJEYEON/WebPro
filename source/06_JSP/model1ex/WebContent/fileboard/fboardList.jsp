<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet">
<style>
#content_form {
	height: 570px;
	padding-top: 30px;
}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<table>
			<!-- <caption>게시판</caption> -->
			<tr>
				<td><a href="<%=conPath%>/fileboard/fboardWriteForm.jsp">글쓰기</a></td>
			</tr>
		</table>
		<table>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>글제목</th>
				<th>메일</th>
				<th>IP</th>
				<th>작성일</th>
				<th>조회수</th>
				</td>
			</tr>
			<%
				//list.jsp또는 list.jsp?pageNum=12
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1"; //전달받은pageNum파라미터가 없으면1page로 처리
			}
			int currentPage = Integer.parseInt(pageNum);
			final int PAGESIZE = 10, BLOCKSIZE = 10;
			int startRow = (currentPage - 1) * PAGESIZE + 1; //화면에 뿌릴 첫번째 로우 번째수
			int endRow = startRow + PAGESIZE - 1; // 화면에 뿌릴 마지막로우 번째수

			FileBoardDao fDao = FileBoardDao.getInstance();
			int totalCnt = fDao.boardTotalCnt(); //글 전체갯수
			if (totalCnt == 0) {
				out.print("<tr><td colspan'5'>등록된 글이 없습니다</td></tr>");
			} else {
				ArrayList<FileBoardDto> dtos = fDao.listboard(startRow, endRow);
				for (FileBoardDto dto : dtos) {
					//글번호
					out.print("<tr><td>" + dto.getFid() + "</td>");
					//작성자
					out.print("<td>" + dto.getCid() + "</td>");
					//제목(왼쪽정렬. 조회수가 10이상이면hot이미지 출력. 제목 클릭시 상세보기 페이지로)
					out.print("<td class='left'>");
					if (dto.getFindent() > 0) {//답변글이라 들여쓰기
				int width = dto.getFindent() * 15;
				out.print("<img src='" + conPath + "/img/level.gif' width='" + width + "' height='10'>");
				out.print("<img src='" + conPath + "/img/re.gif'>");
					}
					if (dto.getFhit() > 10) {
				out.print("<img src='" + conPath + "/img/hot.gif'>");
					}
					out.print("<a href='" + conPath + "/fileboard/fboardContent.jsp?fid=" + dto.getFid() + "&pageNum=" + pageNum + "'>");
					out.print(dto.getFtitle());
					out.print("</a>");
					out.print("</td>");
					//메일
					String email = dto.getCemail();
					out.print("<td>" + (email==null? "-":email) + "</td>");
					//ip
					out.print("<td>" + dto.getFip() + "</td>");
					//작성일
					out.print("<td>" + dto.getFdate() + "</td>");
					
					//조회수
					out.print("<td>" + dto.getFhit() + "</td></tr>");
				}
			}
			%>
		</table>
		<div class="paging">
			<%
				int pageCnt = (int) Math.ceil((double) totalCnt / PAGESIZE); //페이지갯수
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1; //보이는시작페이지 번째수
			int endPage = startPage + BLOCKSIZE - 1; //보이는 몇개의 페이지를 뿌릴지 last번째수
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}
			if (startPage > BLOCKSIZE) { //BLOCKSIZE가10인데 11이 넘어갈경우
				out.print("[ <a href='" + conPath + "/fileboard/fboardList.jsp?pageNum=" + (startPage - 1) + "'>이전</a> ]"); //현제 보이는 첫번째 페이지의-1값을 이전으로 뿌려라
			}
			for (int i = startPage; i <= endPage; i++) { //예)현 페이지가 1이라면 1부터10페이지까지 뿌려라
				if (i == currentPage) {
					out.print("[ <b>" + i + "</b> ]");
				} else {
					out.print("[ <a href='" + conPath + "/fileboard/fboardList.jsp?pageNum=" + i + "'>" + i + "</a> ]"); //파라미터 i=pageNum
				}
			}
			if (endPage < pageCnt) {
				out.print("[ <a href='" + conPath + "/fileboard/fboardList.jsp?pageNum=" + (endPage + 1) + "'>다음</a>]");
			}
			%>
		</div>
	</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>