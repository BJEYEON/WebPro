<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html주석 -->
	<%--jsp주석 --%>
	<% //스크립트 내의 자바 주석
		int j=0; //초기화하지 않으면 쓰레기 데이터 지역변수j는 실행할때마다 초기화
		String str_local = "몰라요";
		i++; j++;
		str_global += "<span>★</span>";
		str_local += "<span>@</span>";
		out.println("전역변수 i= " + i + "<br>");
		out.println("전역변수 str_global = " + str_global + "<br>");
		out.println("지역변수 j= " + j + "<br>");
		out.println("전역변수 str_local = " + str_local + "<br>");
		
	%>
	<%! //!가 선언부라 먼저실행 전역변수i는 메모리에 기존값이 남음
		int i; //선언부의 변수는 초기화하지 않아도 자동초기화 (0,null);	
		String str_global = "Good";
	%>
</body>
</html>