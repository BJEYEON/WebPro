<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp"%>

<link href="css/admincss.css" rel="stylesheet">

<style>
.mypage-btn-dede-wrap {position:relative; width:1100px; height:60px; margin:0 auto;}
.dede:hover, .dede:focus {background: #373737; border-color: #373737; color: #fff;}
.dede{background-color: #555; color: #fff;display: inline-block;padding: 0 10px;font-size: 12px; font-weight:400; text-align:center;
  white-space: nowrap;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;
  -webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none;border: 1px solid transparent;
  text-transform: uppercase;-webkit-border-radius: 0;-moz-border-radius: 0;border-radius: 0;
  -webkit-transition: all 0.3s;-moz-transition: all 0.3s;-ms-transition: all 0.3s; -o-transition: all 0.3s;
  transition: all 0.3s; margin:20px 0;}
</style>

<form name="frm" method="post">
<section class="notice">
  <div class="page-titlee">
        <div class="containerr">
             <h3 style="font-size: 28px;color: #333333;font-weight: 400;text-align: center;">${name}님의 주문 내역</h3>
        </div>
    </div>
    <div class="board-listt">
        <div class="containerr">
            <table class="board-tablee">
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
                        	<b style="color:red;">결제 완료</b>
                  		</td>
	                	<td>
	                		<input type="checkbox" name="cseq" value="${cart2VO.cseq}">
	                	</td>
	                </tr>
	          	</c:forEach>
                
                </tbody>
            </table>
        </div>
        <div class="mypage-btn-dede-wrap">
			    <div class="dede" style="float:right;">
			    	<a href="#" onClick="go_admin_return('${name}','${id}');"><h3>환불하기</h3></a>
		    	</div>
        	</div>
<br><br><br><br><br>
</div>
</section>
</form>
<%@ include file ="../footer.jsp"%>