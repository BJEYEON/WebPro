package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 수정할 부서번호와 부서명, 근무지를 입력받아 update전송 priparedstatment사용
public class Ex4_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 부서번호는?");
		int deptno = scanner.nextInt();
		//부서번호 유무확인
		System.out.println("수정할 부서명은?");
		String dname = scanner.next();
		System.out.println("수정할 위치는?");
		String loc = scanner.next();
		//String sql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
		String sql = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			//int result = stmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? deptno + "번 부서 수정성공" : deptno + "번 부서번호가 없어서 수정실패");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
