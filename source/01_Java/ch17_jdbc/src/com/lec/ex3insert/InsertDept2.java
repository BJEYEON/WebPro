package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;   

// 사용자에게 부서번호를 받아 중복체크 후, 부서명, 근무지를 입력받고 dept테이블에insert
public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.println("입력할 부서번호는?(숫자 2자리 이내)");
			int deptno = scanner.nextInt();
			//부서번호 중복체크
			String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=" + deptno;
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("cnt");
			if (cnt==1) {
				System.out.println("중복된 부서번호는 입력 불가합니다");
			}else {
				System.out.println("입력할 부서이름은?");
				String dname = scanner.next();
				System.out.println("입력할 부서위치는?");
				String loc = scanner.next();
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(sql);// executeUpdate(sql) : insert, update, delete문 전송
														// executequery() : select문전성 - 결과 resultset
				System.out.println(result > 0 ? "입력성공" : "입력실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}// last catch
		}//finally

	}//main
}
