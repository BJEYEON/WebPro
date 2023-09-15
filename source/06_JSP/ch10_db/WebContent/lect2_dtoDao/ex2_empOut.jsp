<%@page import="com.lec.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@page import="com.lec.dao.EmpDao"%>
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
<table>
	<%
		String str_deptno = request.getParameter("deptno");
		if(str_deptno==null){
			str_deptno = "0";
		}
		int deptnoInput = Integer.parseInt(str_deptno);
		EmpDao eDao = EmpDao.getInstance();
		ArrayList<EmpDto> empList = eDao.deptnoEmpList(deptnoInput);
		
		//emplist출력
		out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>부서번호</th></tr>");
		if (empList.size()!=0){
			for(int i=0; i<empList.size(); i++){
				out.print("<tr><td>" + empList.get(i).getEmpno() + "</td>"
							+ "<td>" + empList.get(i).getEname() + "</td>"
							+ "<td>" + empList.get(i).getJob() + "</td>"
							+ "<td>" + empList.get(i).getDeptno() + "</td>");
			}
				out.print("<tr><td colspan='4'>이상 총" + empList.size() + "명</td></tr>");
		}else{
			out.print("<tr><td colspan='4'>해당부서번호의 사원이 없습니다</td></tr>");		
		}
	%>
	</table>
</body>
</html>