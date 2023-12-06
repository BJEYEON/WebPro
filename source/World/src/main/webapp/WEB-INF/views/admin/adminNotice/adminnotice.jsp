<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp"%>
<style>
#plusebtn{position: absolute; right:45px; bottom:15px;  }
#btn2{width:110px; background: #555;color: #fff; font-size: 25px;}
</style>

<form name="frm" method="post">
<section class="notice">
	<div class="page-title">
		<div class="container">
            <h3 style="margin-right:70px; font-size: 60px;color: #333333;font-weight: 400;text-align: center;">공지사항</h3>
        </div>
    </div>
    <div class="board-searchh">
		<div class="containerr">
			<div class="search-window">
				<div class="search-wrap">
                    <label for="search" class="blind"> 공지사항 내용 검색 </label>
                    <input id="search" type="search" name="key" placeholder="검색어를 입력해주세요." value="${key}">  
                    <button type="submit" class="btn btn-dark" value="검색" onClick="go_search('adminNotice')">검색</button>
                    <button type="submit" class="btn btn-dark" value="전체보기" onClick="go_total('adminNotice')">전체보기</button>
					<button type="submit" class="btn btn-dark" value="추가" onClick="go_insertform('insertnoticeForm')">추가</button> 
				</div>        
			</div>
		</div>
    </div>

    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
	                <tr>
	                    <th scope="col" class="th-num">번호</th>
	                    <th scope="col" class="th-title">제목</th>
	                    <th scope="col" class="th-date">등록일</th>
	                </tr>
                </thead>
                <tbody>
	                <c:forEach items="${noticeList}"  var="noticeVO">
		                <tr>
		                    <td>${noticeVO.nseq}</td>
		                    <td><a href="#" onClick="go_detail('${noticeVO.nseq}')">${noticeVO.title}</a></td>
		                    <td><fmt:formatDate value="${noticeVO.indate}" type="date"/></td>
		                </tr>
		          	</c:forEach>
                </tbody>
            </table>
        </div>
        <br>
		<jsp:include page="../paging/paging.jsp">
			<jsp:param name="command" value="adminNotice" />
		</jsp:include>
		<br><br><br><br><br>
    </div>
</section>
</form>
<%@ include file ="../footer.jsp"%>
