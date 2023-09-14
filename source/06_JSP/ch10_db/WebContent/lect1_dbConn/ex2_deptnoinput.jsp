<%@page import="java.sql.DriverManager"%>
<%@page import="jdk.nashorn.internal.ir.ForNode"%>
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
		p{text-align: center;}
	</style>
</head>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "SELECT * FROM DEPT";
%>
<body>
	<form action="ex2_empOut.jsp">
		<p>
			부서번호
			<select name="deptno">
				<option value="0"></option>
				<%
					try{
						Class.forName(driver);
						conn = DriverManager.getConnection(url, "scott", "tiger");
						pstmt = conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						while(rs.next()){
							//<option value='10'>10-ACCOUNT-NEW YORK</option> 이런거 만드는거
							int deptno = rs.getInt("deptno");
							String dname = rs.getString("dname");
							String loc = rs.getString("loc");
							out.print("<option value='"+deptno+"'>"
										+deptno+"-"+dname+"-"+loc+"</option>");
							
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
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
</body>
</html>