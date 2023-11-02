<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i=0 ; i<70 ; i++){
		dto.setFtitle("좋은 정보 " + i);
		dto.setFcontent(i+"번째 본문");
		dto.setFip("192.168.10."+i);
		if(i%5!=0){
			dto.setMid("go");
			dto.setFfileName(null);
			dao.writeBoard(dto);			
		}else if(i%5==0){
			dto.setMid("gico");
			dto.setFfileName("a.docx");
			dao.writeBoard(dto);		
		}	
	}
	response.sendRedirect("../boardList.do");
%>
</body>
</html>