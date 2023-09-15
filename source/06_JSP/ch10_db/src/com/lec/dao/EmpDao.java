package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.dto.EmpDto;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

public class EmpDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	private static EmpDao INSTANCE = new EmpDao(); //자기클래스를 참조하는 static변수
	public static EmpDao getInstance() {
		return INSTANCE;
		
	}
	
	private EmpDao() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//ex1:모든empList반환
	public ArrayList<EmpDto> empList(){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = DriverManager.getConnection(url, uid, upw);//2
			pstmt = conn.prepareStatement(sql);//3
			rs = pstmt.executeQuery(); //4+5
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 Date hiredate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
		return dtos;
	}
	//ex2:해당 부서번호의 emplist반환(dname비포함)
	public ArrayList<EmpDto> deptnoEmpList(int deptno){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM EMP WHERE DEPTNO LIKE '%' || ?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);//2
			pstmt = conn.prepareStatement(sql);//3
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); //4+5
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 Date hiredate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 deptno = rs.getInt("deptno");
				 dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, null));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
		return dtos;
	}
	//ex3:해당부서번호의 empList반환(dname포함
	public ArrayList<EmpDto> dnameempList(int deptno){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT E.*, DNAME " + 
				"    FROM EMP E, DEPT D " + 
				"    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, uid, upw);//2
			pstmt = conn.prepareStatement(sql);//3
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); //4+5
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 Date hiredate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 deptno = rs.getInt("deptno");
				 String dname = rs.getString("dname");
				 dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
		return dtos;
	}
	//example: 해당이름이 포함된empList반환
	public ArrayList<EmpDto> enameEmplList(String schName){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL,COMM, E.DEPTNO, DNAME" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER(?))||'%'";
		try {
			conn = DriverManager.getConnection(url, uid, upw);//2
			pstmt = conn.prepareStatement(sql);//3
			pstmt.setString(1, schName);
			rs = pstmt.executeQuery(); //4+5
			while(rs.next()) {
				 int empno = rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 Date hiredate = rs.getDate("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 String dname = rs.getNString("dname");
				 dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno, dname));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
		return dtos;
	}
}
