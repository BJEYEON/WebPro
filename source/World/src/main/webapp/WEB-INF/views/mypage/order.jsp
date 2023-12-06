<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script src="mypage/mypage.js"></script>

<form name="formm" method="post">
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style="font-size: 28px;color: #333333;font-weight: 400;text-align: center;">나의 주문 내역</h3>
            <h4> 아래의 상품들이 결제가 완료되었습니다.</h4>
        </div>
    </div>
    <div class="board-list">
        <div class="container" style="width:800px; ">
            <table class="board-table">
                <thead>
                <tr>
                	<th scope="col" class="th-num">주문일자</th>
                    <th scope="col" class="th-num">주문번호</th>
                    <th scope="col" class="th-num">티켓유형</th>
                    <th scope="col" class="th-date" style="text-align:center;">인원수</th>
                    <th scope="col" class="th-date" style="text-align:center;">가격</th>
                    <th scope="col" class="th-date">어트랙션</th>
                    <th scope="col" class="th-num">방문일자</th>
                    <th scope="col" class="th-num">총액</th>
          
                
          
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
	                	<td><input type="checkbox" name="cseq" value="${cart2VO.cseq}"></td>
	                </tr>
	          	</c:forEach>
                
                </tbody>
            </table>
        </div>
    </div>
    </section>
    </form>
   