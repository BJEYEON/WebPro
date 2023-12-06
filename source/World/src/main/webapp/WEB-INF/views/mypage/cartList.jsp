<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>
<script src="script/mypage.js"></script>



<form name="formm" method="post">
<section class="notice">
   <div class="page-title">
        <div class="container">
            <h3 style="font-size: 28px;color: #333333;font-weight: 400;text-align: center;">장바구니</h3>
            <br><h1 style="font-size: 15px; text-align:center;">${message}</h1>
        </div>
    </div>  
    
    
    <div class="board-list">
        <div class="container" style="width:1000px; ">
	        <div class="mypage-btn-dede-wrap">
	 			<nav id="sub_mypage" style="float:right;">
				<ul style= "font-weight:bold;
							color:#5c10e6;"
				>
					<li><a href='orderList'>주문내역 이동 </a></li>
				</ul>
				</nav>
	    	</div>
            
            <table class="board-table">
                <thead>
                <tr>
                	<th scope="col" class="th-num">주문일자</th>
                    <th scope="col" class="th-num">주문번호</th>
                    <th scope="col" class="th-num">티켓유형</th>
                    <th scope="col" class="th-date">인원수</th>
                    <th scope="col" class="th-num">가격</th>
                    <th scope="col" class="th-date">어트랙션</th>
                    <th scope="col" class="th-num">방문일자</th>
                    <th scope="col" class="th-num">총액</th>
                    <th scope="col" class="th-num">처리 상태</th>
                    <th scope="col" class="th-date">선택</th>
                
          
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartList}"  var="cart2VO">
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
                        	<c:when test='${cart2VO.result == 0}'>결제 대기</c:when>                  
                         	<c:otherwise><b style="color:red;">결제 완료</b></c:otherwise>
                     		</c:choose>
                  		</td>
	                	<td>
	                	<c:choose>
                        	<c:when test='${cart2VO.result == 0}'>
	                			<input type="checkbox" name="cseq" value="${cart2VO.cseq}">
	                		</c:when>
	                		<c:otherwise><a href="#"onClick="go_orderList()">주문내역 확인</a></c:otherwise>
	                	</c:choose>
	                	</td>
	                </tr>
	          	</c:forEach>
                
                </tbody>
            </table>
            <div class="mypage-btn-dede-wrap">
			    <div class="dede" style="float:right;">
			    	<a href="#"onClick="go_cart_delete()"><h3>삭제하기</h3></a>
			    </div>
			    <div class="dede" style="float:right;">
			    	<a href="#"onClick="go_order()"><h3>결제하기</h3></a>
		    	</div>
        	</div>
    	</div>
    </div>
</section>
</form>
<br>
<jsp:include page="../paging/page.jsp">
	<jsp:param name="command" value="cartList" />
</jsp:include>

<br><br><br><br><br><br><br>
 
<%@ include file="../footer.jsp" %>