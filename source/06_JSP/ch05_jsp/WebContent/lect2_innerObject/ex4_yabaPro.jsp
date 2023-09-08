<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex4.css" rel="stylesheet">
</head>
<body>
	<%! String suParam; int su; %> <%--변수선언 --%>
	<%
	String suParam = request.getParameter("su");
	if(suParam!=null){
		su = Integer.parseInt(suParam);
		//su와 컴퓨터가 발생한 난수를 비교하여 분기or머무르거나
		//1<= Math.random() < 1
		//int computersu = (int)(Math.random()*3)+1;
		Random random = new Random();
		int computersu = random.nextInt(3)+1; //1,2,3중 난수 발생
		if(su != computersu){
			String msg = "<h2>Wrong!</h2>" + 
							"<h3>" + su + "는 아니고 정답은" + computersu + "</h3>";
			msg = URLEncoder.encode(msg, "utf-8"); //한글을파라미터를 넘기기위한 작업
			response.sendRedirect("ex4_yaba.jsp?msg=" + msg);
		}
	}else{
		response.sendRedirect("ex4_yaba.jsp");
	}
	%>
	<div id="wrap">
		<h2>정답입니다</h2>
		<h3>동전이 있던 곳은 <%=su %></h3>
		<button onclick="location.href='ex4_yaba.jsp'">다시도전</button>
	</div>
</body>
</html>