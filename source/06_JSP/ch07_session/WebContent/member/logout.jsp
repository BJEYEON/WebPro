<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<script>
setTimeout(() => {
	location.href='<%=conPath%>/member/main.jsp';
}, 3000);

setTimeout("location.href='../member/main.jsp'",3000);
</script>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../member/header.jsp"/>
	<%
		String name = (String)session.getAttribute("name");
		if(name!=null){//로그인상태
			session.invalidate();
			out.println("잠시후 화면 전환이 있겠습니다.");
			
		}else{//로그인 안된상태
			out.println("로그인 상태가 아닙니다");
		}
		
	%>
<jsp:include page="../member/footer.jsp"/>
</body>
</html>