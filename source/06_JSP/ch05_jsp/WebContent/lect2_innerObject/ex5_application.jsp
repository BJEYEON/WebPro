<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Reader"%>
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
	String conPath = request.getContextPath(); //ch05_jsp
	String appPath = application.getContextPath(); //ch05_jsp
	String absolutePath = application.getRealPath("."); //현재 실행되는 절대경로
%>
	<h2>conPath: <%=conPath %></h2>
	<h2>appPath: <%=appPath %></h2>
	<h2>absolutePath: <%=absolutePath %></h2>
<%
	String filePath = application.getRealPath("txt/test.txt");
	out.println(filePath + "의 내용입니다<br>");
	//1. 스트림객체생성(파일연다. 기본스트림->보조스트림) 2. 읽고 화면출력 3.스트림닫는다(파일을닫는다)

			Reader reader = new FileReader(filePath);// 1.기본스트림 생성
			BufferedReader br = new BufferedReader(reader);// 보조스트림은 기본스트림을 통해 생성
			while (true) {// 2. 데이터를 한줄씩 읽는다(br.readerLine())
				String linedata = br.readLine();
				if (linedata == null) {
					break;
				}
				System.out.println(linedata);
				out.println(linedata +"<br>");
			}
			out.println("== 파일끝 ==");
			System.out.println("= = 파일입력끝 = =");
			br.close();
			reader.close();
		/* Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader(filePath);// 1.기본스트림 생성
			br = new BufferedReader(reader);// 보조스트림은 기본스트림을 통해 생성
			while (true) {// 2. 데이터를 한줄씩 읽는다(br.readerLine())
				String linedata = br.readLine();
				if (linedata == null) {
					break;
				}
				System.out.println(linedata);
				out.println(linedata +"<br>");
			}
			out.println("== 파일끝 ==");
			System.out.println("= = 파일입력끝 = =");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {// 3.스트림을 순서대로 닫는다
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} */
%>
</body>
</html>