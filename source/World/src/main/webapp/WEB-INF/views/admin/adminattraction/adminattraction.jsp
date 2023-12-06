<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<div style="clear: both;"></div>
<link href="css/admincss.css" rel="stylesheet">
<style>
   #buttons{text-align:center;}
.submit{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color: #fff; background:rgb(111, 35, 249);;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
.cancel{position:relative; font-size: 20px;padding-bottom:10px; width:200px; height:55px;color:#6317ed; background:white;font-weight:bold;border-radius: 28px;border:1px solid #6317ed;}
</style>

<form name="frm" method="post">
<section class="notice">
  <div class="page-titlee">
        <div class="containerr">
            <h3 style=" margin-right:70px; font-size: 60px;color: #333333;font-weight: 400;text-align: center;"> 어트랙션 관리 </h3>
        </div>
    </div>

    <div class="board-searchh">
        <div class="containerr">
            <div class="search-window">
                
                    <div class="search-wrap" >
                        <label for="search" class="blind">어트랙션 검색 </label>
                        <input id="search" type="search" name="key" placeholder="어트랙션 이름을 입력해주세요." value="${key}">
                        <button type="submit" class="btn btn-dark" value="검색" onClick="go_search('adminAttraction')">검색</button>
                        <button type="submit" class="btn btn-dark" value="전체보기" onClick="go_total('adminAttraction')">전체보기</button>
                        <button type="submit" class="btn btn-dark" value="추가" onClick="go_insertform('atInsertForm')"> 추가 </button>
                        <!-- <button type="submit" class="btn btn-darkk" value="추가" onClick="location.href='/atInsertForm'">추가</button> -->
                        
                    </div>
                
            </div>
        </div>
    </div>
   
    <div class="board-listt">
        <div class="containerr">
            <table class="board-tablee">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">어트랙션 이름</th>
                    <th scope="col" class="th-date">운휴일</th>
                   
                </tr>
                </thead>
	     		<c:forEach items="${attractionList}" var="AttractionVO">
					<tr>
						<td>${ AttractionVO.aseq}</td>
			    		<td><a href="adminattractionDetail?aseq=${AttractionVO.aseq}">${AttractionVO.atname}</a>
			    		</td><td>${AttractionVO.aresult}</td>
			    	</tr>
		  		</c:forEach>
            </table>
        </div>
		<br>
		<jsp:include page="../paging/paging.jsp">
			<jsp:param name="command" value="adminAttraction" />
		</jsp:include>
    </div>
<br><br><br><br><br>
</section>
</form>
<%@ include file="../footer.jsp" %>

 