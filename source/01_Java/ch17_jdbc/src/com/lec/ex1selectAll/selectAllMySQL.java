package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class selectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0x
		String url = "jdbc:mysql://127.0.0.1:3306/parkdb?serverTimezone=UTC";// 8.0.x
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from personal";
		try {
			Class.forName(driver);// 1.����̹��ε�
			conn = DriverManager.getConnection(url, "root", "mysql");//2.db����
			stmt = conn.createStatement(); //3.sql���۰�ü ����
			rs = stmt.executeQuery(sql); //4.sql���� + 5.sql�� ����ޱ�
			// 6.��� �޾� ���ϴ� ���� ����
			System.out.println("���\t�̸�\t��å\t\t�����\t �Ի���\t �޿�\t ��\t �μ���ȣ\t");
			while(rs.next()) {
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				String job = rs.getString("job");
				String manager = rs.getString("manager");
				Date startdate = rs.getDate("startdate");
				Timestamp startdate1 = rs.getTimestamp("startdate");
				int pay = rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
				if (job.length()>=8) {
					System.out.printf("%d\t%s\t%s\t%s\t%TF\t%d\t%d\t%d\n",
						pno, pname, job, manager, startdate, pay, bonus, dno);
				}else {
					System.out.printf("%d\t%s\t%s\t\t%s\t%TF\t%d\t%d\t%d\n",
							pno, pname, job, manager, startdate, pay, bonus, dno);
				}
				
			}//while
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally { //7db��������
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}//  catch 
		}//finally
	}
}
