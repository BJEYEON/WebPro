<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap{
			width:1000px; margin: 10px auto; height: 600px; 
			border: 1px solid #005500;
			line-height: 600px;
			text-align: center;
			font-size: 2em; color: #005500;
			font-weight: bold;
		}
	</style>
	<script>
		setTimeout(function(){location.href='<%=conPath%>/main/main.jsp';}, 2000);
	</script>
</head>
<body>
	<%
		String msg;
		if(session.getAttribute("customer")!=null){
			session.invalidate();
			msg = "<h4>로그아웃 되었습니다. 메인 페이지로 이동합니다</h4>";
		}else{
			msg = "<h4>로그인 상태가 아닙니다. 메인 페이지로 이동합니다</h4>";
		}
	%>
	<jsp:include page="../main/header.jsp"/>
	<div id="mainForm_wrap">
		<%=msg %>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>



