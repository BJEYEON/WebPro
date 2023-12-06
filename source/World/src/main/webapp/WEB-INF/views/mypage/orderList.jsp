<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<script src="script/mypage.js"></script>

<form name="formm" method="post">
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style="font-size: 28px;color: #333333;font-weight: 400;text-align: center;">주문 내역</h3>
            <br><h1 style="font-size: 15px;">${message}</h1>
        </div>
    </div>
    <div class="board-list">
        <div class="container" style="width:1000px; ">
        	<div class="mypage-btn-dede-wrap">
	 			<nav id="sub_mypage" style="float:right;">
					<ul style= "font-weight:bold;
							color:#5c10e6;">
						<li><a href='cartList'>장바구니 이동</a></li>
					</ul>
				</nav>
	    	</div>
	    	
            <table class="board-table">
                <thead>
                <tr>
                	<th scope="col" class="th-num">주문일자</th>
                    <th scope="col" class="th-num">주문번호</th>
                    <th scope="col" class="th-date">티켓유형</th>
                    <th scope="col" class="th-date" style="text-align:center;">인원수</th>
                    <th scope="col" class="th-num" style="text-align:center;">가격</th>
                    <th scope="col" class="th-date">어트랙션</th>
                    <th scope="col" class="th-num">방문일자</th>
                    <th scope="col" class="th-num">총액</th>
                    <th scope="col" class="th-date">처리 상태</th>
                    <th scope="col" class="th-date">선택</th>
                
          
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderList}"  var="cart2VO">
	                <tr>
	                	<td><fmt:formatDate value="${cart2VO.indate}" type="date"/></td>
	                    <td>${cart2VO.cseq}</td>
	                     <td>
                          <c:choose>
                             <c:when test = "${cart2VO.kind==0}">
                                자유이용권
                             </c:when>
                             <c:otherwise>
                                패스트패스   
                             </c:otherwise>
                          </c:choose>
                       </td>
	                    <th>어른 : ${cart2VO.p1}<br> 
	                    	청소년 : ${cart2VO.p2}
	                    </th>
	                    <th> <fmt:formatNumber type="currency" value="${cart2VO.price1}" /><br> 
	                 		 <fmt:formatNumber type="currency" value="${cart2VO.price2}" />
	                    </th>
	                    <td>${cart2VO.tatname1}<br> 
	                    ${cart2VO.tatname2}<br>  
	                    ${cart2VO.tatname3} </td>                  
	                    	<td>${cart2VO.visitdate} </td>
	                	<td><fmt:formatNumber type="currency" value="${cart2VO.price1+cart2VO.price2}" /></td>
	                	<td>
                         	<c:choose>
                        		<c:when test='${cart2VO.result == 1}'><b style="color:red;">결제 완료</b></c:when>
                        		<c:otherwise>결제 대기중</c:otherwise>                  
                     		</c:choose>
                  		</td>
	                	<td>
	                	<c:choose>
                        		<c:when test='${cart2VO.result == 1}'>
	                				<input type="checkbox" name="cseq" value="${cart2VO.cseq}">
	                			</c:when>
	                		<c:otherwise><a href="#"onClick="go_cartList()" style="color:blue;">결제 하러가기</a></c:otherwise>
	                	</c:choose>
	                	</td>
	                </tr>
	          	</c:forEach>
                
                </tbody>
            </table>
            <div class="mypage-btn-dede-wrap">
			    <div class="dede" style="float:right;">
			    	<a href="#"onClick="go_cart_return()"><h3>환불하기</h3></a>
		    	</div>
        	</div>
    	</div>
    </div>
</section>
</form>
<br>
<jsp:include page="../paging/page.jsp">
	<jsp:param name="command" value="orderList" />
</jsp:include>

<br><br><br><br><br><br><br>
 
<%@ include file="../footer.jsp" %>