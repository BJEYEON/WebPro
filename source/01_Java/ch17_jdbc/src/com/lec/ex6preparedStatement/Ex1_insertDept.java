package com.lec.ex6preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// �μ���ȣ, �μ���, ��ġ �Է¹޾� insert
public class Ex1_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("�߰��� �μ���ȣ��?");
		int deptno = scanner.nextInt();
		System.out.println("�߰��� �μ�����?");
		String dname = scanner.next();
		System.out.println("�߰��� �μ� ��ġ��?");
		String loc = scanner.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql); // ?��3���ִ� sql/ pstmt:sql���۰�ü
			pstmt.setInt(1, deptno); // deptno�� int���̶� setint�Լ����
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			//int result = stmt.excuteUpdate(sql)
			int result = pstmt.executeUpdate();
			System.out.println(result>0 ? deptno + "�� �Է� ����": deptno + "�� �Է� ����");
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
				System.out.println(e2.getMessage());
			}
		}
	}
}
