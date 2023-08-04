package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*����ڿ��� �μ���ȣ�� �Է¹�
 * (1)�ش�μ���ȣ�� �����ϸ� : �μ����� ���, �������(���, �̸�, �޿�, ����̸�) ���
 * (2)�ش�μ���ȣ�� �������� ������ : �μ���ȣ�� �������� �ʴ´ٰ� ���
 */
public class Ex2_selectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("����� ���ϴ� �μ���ȣ��?");
		int deptno = scanner.nextInt();
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String sql2 = "SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER" + "    FROM EMP W, EMP M"
				+ "    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=" + deptno;
		try {
			Class.forName(driver);// 1
			conn = DriverManager.getConnection(url, "scott", "tiger");// 2
			stmt = conn.createStatement();// 3
			rs = stmt.executeQuery(sql1);// 4 +5
			if (rs.next()) {
				System.out.println("�μ���ȣ: " + deptno);
				System.out.println("�μ���: " + rs.getString("dname"));
				System.out.println("�μ���ġ" + rs.getString("loc") + "\n");
				// sql2 ���� �� ����޾� ���
				rs.close();
				rs = stmt.executeQuery(sql2);
				if (rs.next()) { // ��������� ���
					System.out.println("���\t�̸�\t�޿�\t���");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + "�� �μ� ����� �����ϴ�");
				}
			} else {
				System.out.println(deptno + "�� �μ��� ��ȿ�� �μ���ȣ�� �ƴմϴ�");
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
				// TODO: handle exception
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
