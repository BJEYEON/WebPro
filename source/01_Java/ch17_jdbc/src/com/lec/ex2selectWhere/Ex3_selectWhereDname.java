package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//사용자로부터 부서명을 입력받아 해당 부서정보를 출
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서명은?");
		String dname = scanner.next();
		String sql = "SELECT * FROM DEPT WHERE DNAME ='" + dname + "'";
		sql = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String deptno = rs.getString("deptno");
				String loc = rs.getString("loc");
				System.out.println(dname + "의 부서정보는 다음과 같습니다");
				System.out.println("부서번호: " + deptno);
				System.out.println("부서명: " + rs.getString("dname"));
				System.out.println("부서위치: " + loc);
				
			}else {
				System.out.println("해당 부서번호는 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
}
