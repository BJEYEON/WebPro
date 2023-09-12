<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String agree = request.getParameter("agree");// "y" "n" null
		if(agree!=null && agree.equals("y")){
			//약관에 동의한 경우 : 세션 속성값(id, pw, name) 받아 파일 저장. 세션 속성값(pw, name) 삭제-> result.jsp?msg-success
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			//파일에 저장(소스폴더의 webContent/WEB-INF/id.txt)
			String filePath = "C:/WebPro/source/06_JSP/ch07_session/WebContent/WEB-INF/" + id + ".txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.println("오늘 DB에 INSERT하는 대신 파일 출력\n");
			writer.println("id:" + id);
			writer.println("pw" + pw);
			writer.println("이름" + name);
			writer.close(); //close생략시 저장안됨
			session.removeAttribute("pw");
			session.removeAttribute("name");
			//세션에 id속성은 유지(로그인 페이지 사용예정)
			response.sendRedirect("result.jsp?msg=success");
			
		}else{
			//약관에 동의하지 않았거나 이 파일부터 실행한 경우: 세션날림 ->다음페이지로 result.jsp?msg=fail
			session.invalidate();//데이터 초기화
			response.sendRedirect("result.jsp?msg=fail");
		}
	%>
</body>
</html>