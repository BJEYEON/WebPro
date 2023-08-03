package com.lec.ex0Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver); // 1. ����̹� �ε�
			System.out.println("1.����̹��ε� ����");
			conn = DriverManager.getConnection(url, "scott", "tiger");// 2. db���ᰴü
			System.out.println("2. oracle���Ἲ��");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null)
					conn.close(); // �������ܰ� : db��������
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
