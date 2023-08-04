package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//����ڷκ��� �μ����� �Է¹޾� �ش� �μ������� ��
public class Ex3_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� �μ�����?");
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
				System.out.println(dname + "�� �μ������� ������ �����ϴ�");
				System.out.println("�μ���ȣ: " + deptno);
				System.out.println("�μ���: " + rs.getString("dname"));
				System.out.println("�μ���ġ: " + loc);
				
			}else {
				System.out.println("�ش� �μ���ȣ�� �������� �ʽ��ϴ�.");
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
