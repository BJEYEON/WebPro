
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link href="css/worldcss.css" rel="stylesheet">
<style>
   
#buttons{text-align:center;}


.submit{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color: #fff; background:rgb(111, 35, 249);;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
.cancel{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color:#6317ed; background:white;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
</style>
<form name="frm" method="post">
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style="font-family:'IBM Plex Sans KR', sans-serif; font-size: 50px; text-align:center;">모바일 QnA</h3>
        </div>
    </div>

    <div class="board-searchh">
        <div class="container">
            <div class="search-window">
             
                    <div class="search-wrap">
                        <label for="search" class="blind">QnA 내용 검색</label>
                        <input id="search" type="search" name="key" placeholder="검색어를 입력해주세요." value="${key}">
                        <button type="submit" class="btn btn-dark" onClick="go_search('mobileQnaList')">검색</button>
                     <button type="submit" class="btn btn-darkkk" value="전체보기" onClick="go_total('mobileQnaList')">전체보기</button> 
                    </div>
  
            </div>
        </div>
    </div>
   
    <div class="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-date">등록일</th>
                    <th scope="col" class="th-answer">답변여부</th>
                </tr>
                
                </thead>
               
<!-- <a href="qnaView?lqseq=${qnaVO.lqseq}">${qnaVO.title}</a> -->
		<c:forEach items="${qnaList}"  var="qnaVO">
			<tr ><td> ${qnaVO.lqseq}</td>    
	    		<td>
	    			<c:choose>
						<c:when test="${qnaVO.passcheck == 'Y'}">
							<a href="#" onClick="passCheck('${qnaVO.lqseq}')">${qnaVO.title}</a>
								&nbsp;<img src="/images/key.png" style="width:20px;vertical-align: middle">
						</c:when>
						<c:otherwise>
							<a href="qnaView?lqseq=${qnaVO.lqseq}">${qnaVO.title}</a>
						</c:otherwise>
					</c:choose>
	    		</td>      
	       		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
	       		<td><c:choose>
					<c:when test="${qnaVO.rep=='N'}"> no </c:when>
					<c:when test="${qnaVO.rep=='Y'}"> yes </c:when>
				</c:choose></td>    
	   		</tr>
	  	</c:forEach>

            </table>
        </div>
    </div>

</section>
</form>

	<jsp:include page="../paging/page.jsp">
		<jsp:param name="command" value="qnaList" />
	</jsp:include>


<div  class="clear"></div><br>


<div id="buttons">
   <input type="button"  value="등록하기"  class="submit" 
      onClick="location.href='qnaWriteForm'"> 
   <input type="button"   value="취소"  class="cancel"    
      onclick="location.href='qnaList'">  
</div>
<div  class="clear"></div><br>



<%@ include file="../footer.jsp" %>