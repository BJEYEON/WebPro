<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<style>
		p {text-align: center;}
	</style>
	
</head>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
%>
<body>
	<form action="">
		<p>
			부서번호
			<select name="deptno">
				<option value="0"></option>
				<%
					String str_deptno = request.getParameter("deptno");
					if(str_deptno==null){// 선택한 값이 없으면0을넣어 전부다나오게
						str_deptno= "0";
					 }
					int int_deptno = Integer.parseInt(str_deptno);
					String sql = "SELECT * FROM DEPT";
					try{
						Class.forName(driver); //1
						conn = DriverManager.getConnection(url, "scott", "tiger");//2
						pstmt = conn.prepareStatement(sql); //3
						rs = pstmt.executeQuery(); //4+5
						while(rs.next()){
							//<option value="20" selected='selected'>20-sales-boston</option>
							//<option value='20'>20-sales-boston</option>
							int deptno = rs.getInt("deptno");
							String dname = rs.getString("dname");
							String loc = rs.getString("loc");
							if(int_deptno == deptno){
								out.print("<option value='"+deptno+"' selected='selected'>"+deptno+"-"+dname+"-"+loc+"</option>");
							}else{
								out.print("<option value='"+deptno+"'>"+deptno+"-"+dname+"-"+loc+"</option>");
							}
							
						}//while
						
					}catch(Exception e){
						System.out.print(e.getMessage());
					}finally{
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					}
				%>
			</select>
			<input type="submit" value="검색" class="btn">
		</p>
	</form>
	<table>
		<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th><th>부서명</th></tr>
		<%
			sql = "SELECT EMPNO, ENAME, HIREDATE, E.DEPTNO, DNAME " + 
				    " FROM EMP E, DEPT D" + 
				    " WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||?";
			try{
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, int_deptno);
				rs = pstmt.executeQuery();
				if(rs.next()){
					//해당부서 번호의 사원이 있는경우
					do{
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						int deptno = rs.getInt("deptno");
						String dname = rs.getString("dname");
						out.print("<tr><td>" + empno + "</td>"
									+ "<td>" + ename + "</td>"
									+ "<td>" + hiredate + "</td>"
									+ "<td>" + deptno + "</td>"
									+ "<td>" + dname + "</td></tr>");
					}while(rs.next());
				}else{
					out.println("<tr><td colspan='5'>해당부서 번호의 사원이 없습니다</td></tr>");
				}
			}catch(Exception e){
				System.out.print(e.getMessage());
			}finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}
		%>
	
	</table>
</body>
</html>