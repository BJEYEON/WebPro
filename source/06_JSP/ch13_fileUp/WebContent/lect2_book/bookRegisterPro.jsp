<%@page import="com.lec.book.BookDao"%>
<%@page import="com.lec.book.BookDto"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		//첨부한 파일 (서버에)저장하고 파일이름 받아온다
		String path = request.getRealPath("bookImg");
		out.println("서버에 저장될 폴더:" + path + "<br>");
		int maxSize = 1024*1024*3; //최대 업로드 사이즈를3m
		String[] images = {"",""};
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			int idx = 0;
			while(params.hasMoreElements()){
				String param = params.nextElement();
				images[idx] = mRequest.getFilesystemName(param);
				System.out.println(idx + "번째 처리한 파라미터:" + param + "/파일명:" + images[idx]);
				idx++;
			}
		}catch(IOException e){ 
			System.out.print(e.getMessage());
		}
		// 서버에 자장된 파일을 소스폴더로 복사 (사용자에게 배포시 제거 로직)
		for (String filename : images){
			InputStream is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path + "/" + filename); //서버에 업로드된파일
				if(filename!=null){
					is = new FileInputStream(serverFile); //서버에 업로드된파일
					os = new FileOutputStream("C:\\WebPro\\source\\06_JSP\\ch13_fileUp\\WebContent\\bookImg\\" + filename); //소스폴더로 복사될파일
					
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readByteCnt = is.read(bs);
						if(readByteCnt == -1)break;
						os.write(bs, 0, readByteCnt);
					}
					System.out.println(filename + "복사완료");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
		// btitle, bprice, bcontent, bdiscount 파라미터값 받아온다
		String btitle = mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimage1 = images[1]==null? "noImg.png" : images[1];
		String bimage2 = images[0]!=null ? images[0]: "nothing.png";
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		//String ip = request.getRemoteAddr(); ip가필요한경우
		//db저장
		BookDto book = new BookDto(0,  btitle,  bprice,  bimage1,  bimage2,  bcontent,  bdiscount,null);
		BookDao bDao = BookDao.getInstance();
		int result = bDao.insertBook(book);
		if(result!=BookDao.SUCCESS){
			out.print("<h2>책등록 성공</h2");
		}else{
			out.print("<h2>책등록 실패</h2>");
		}
	%>
	<h3>책이름<%=btitle %></h3>
	<h3>
	<%if(bdiscount!=0){ %>
		책가격 <del><%=bprice %></del>
		<b>
			<%=bprice * (100-bdiscount) / 100 %>원(<%=bdiscount %>%할인)
		<%}else{%>
			책가격<%=bprice %>원
		<%} %>
		</b>
	</h3>
	<h3>대표이미지: <%=path %>/bookImg/<%=bimage1 %></h3>
	<h3>추가이미지: <%=path %>/bookImg/<%=bimage2 %></h3>
	<img src="<%=conPath %>/bookImg/<%=bimage1 %>" alt="대표이미지">
	<img src="<%=conPath %>/bookImg/<%=bimage2 %>" alt="추가이미지">
	<h3>책설명</h3>
	<pre><%=bcontent %></pre>
	<hr>
	<a href="ex1_listBoardStyle.jsp">책 전체 리스트(게시판 스타일)</a> <br>
	<a href="ex2_list.jsp">책 리스트 1page(게시판 스타일)</a> <br>
	<a href="ex3_listProduct_nopaging.jsp">책 전체 리스트(제품리스트 스타일)</a> <br>
	<a href="ex4_list.jsp">책 리스트 1page(제품리스트 스타일)</a> <br>
</body>
</html>