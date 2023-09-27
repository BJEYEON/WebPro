<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
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
		String path =  request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
																new DefaultFileRenamePolicy()); // 서버에 파일 저장
			Enumeration<String> params = mRequest.getFileNames(); 
				String param = params.nextElement();
				filename = mRequest.getFilesystemName(param);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일 소스폴더로 복사
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path+"/"+filename);
			if(serverFile.exists()){
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("C:\\WebPro\\source\\06_JSP\\model1ex\\WebContent\\fileboardUpload\\" + filename);
				byte[] bs = new byte[(int)serverFile.length()];
				int nReadByteCnt;
				while((nReadByteCnt=is.read(bs))!=-1){
					os.write(bs, 0, nReadByteCnt);
				}
			}
		}catch(IOException e){
			System.out.println("복사 예외 : "+e.getMessage());
		}finally{
			if(is!=null) is.close();
			if(os!=null) os.close();
		}
		String cid = ((CustomerDto)session.getAttribute("customer")).getCid();
		String ftitle = mRequest.getParameter("ftitle");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw  = mRequest.getParameter("fpw");;
		String fip = request.getRemoteAddr();
		FileBoardDto Dto = new FileBoardDto(0, cid, ftitle, fcontent, filename, 0, fpw, 0,
					0, 0, fip, null, null, null);
		FileBoardDao fDao = FileBoardDao.getInstance();
		int result = fDao.writeboard(Dto);
		if(result==FileBoardDao.SUCCESS){
	%>
			<script>
				alert('글쓰기 성공');
				location.href = 'fboardList.jsp';
			</script>
	<%}else{%>
			<script>
				alert('글쓰기 실패');
				history.back();
			</script>
	<%}%>
	
</body>
</html>