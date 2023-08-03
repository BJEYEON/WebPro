package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);//1. ����̹��ε�
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement(); // 3. sql���۰�ü
			rs = stmt.executeQuery(sql); // 4. sqp���� + 5.���۰���ޱ�
			//6. ���۰���� ���� ���ϴ� ���� ����
			if (rs.next()) { //select �� ����� 1���̻�
				System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
				do {
					//rs�� ����Ű�� ���� empno, ename, job ,mgr ����������ͼ� ���
					int empno = rs.getInt("empno");
					String ename = rs.getNString("ename");
					String job = rs.getNString("job");
					String mgr = rs.getString("mgr");
					Date hiredate = rs.getDate("hiredate"); // ��¥�� �ð��� 0��0��0��
					Timestamp hiredate1 = rs.getTimestamp("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					if (job.length() >= 8) {
						System.out.printf("%d\t%s\t%s\t%s\t%TF\t%d\t%d\t%d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}else {
						System.out.printf("%d\t%s\t%s\t\t%s\t%TF\t%d\t%d\t%d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
				}while(rs.next());
			}
			else { //select�� ����� ���൵ ���°��
				System.out.println("��ϵ� ����� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
