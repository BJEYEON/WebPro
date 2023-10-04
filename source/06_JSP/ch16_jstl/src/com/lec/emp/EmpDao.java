package com.lec.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDao {
	//싱글톤
	private EmpDao() {}
	private static EmpDao instance = new EmpDao();
	public static EmpDao getInstance() {
		return instance;
	}
	//connection 리턴함수
	private Connection getConnction() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
					
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	//전체리스트:
	public ArrayList<EmpDto> getlistEmp(){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = getConnction();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr"); // mgr이null이면 0으로 가져옴
				 Timestamp hiredate = rs.getTimestamp("hiredate");
				 Date hireDate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 emps.add(new EmpDto(empno, ename, job, mgr, hiredate, hireDate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs !=null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return emps;
	}
	//이름과 직책출력
	public ArrayList<EmpDto> getlistSch(String schName, String schJob){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP" + 
				"    WHERE ENAME LIKE '%'||TRIM(UPPER(?))||'%'" + 
				"        AND JOB LIKE '%' || UPPER(TRIM(?))||'%'";
		try {
			conn = getConnction();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName);
			pstmt.setString(2, schJob);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr"); // mgr이null이면 0으로 가져옴
				 Timestamp hiredate = rs.getTimestamp("hiredate");
				 Date hireDate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 emps.add(new EmpDto(empno, ename, job, mgr, hiredate, hireDate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return emps;
	}
}
