package com.lec.ex1person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null; //�������, 3�����
		PreparedStatement pstmt = null;// 1��, 2�� ���
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>(); // db�� �ִ� �������add
		try {
			sql ="SELECT JNAME FROM JOB";
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott", "tiger"); //2
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //4,5
			while(rs.next()) {
				jobs.add(rs.getString("jname"));
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
				// TODO: handle exception
			}//catch
		}//finally
		//System.out.println("db���ִ� �������" + jobs);
		do {
			System.out.println("1:�Է� || 2:��������ȸ || 3:��ü��ȸ || �׿�:����");
			fn = scanner.next();
			switch(fn) {
			case "1": //�̸�, ������, ��, ��, �� �Է¹޾� insert
				sql = "INSERT INTO PERSON "
						+ "VALUES (PERSON_PNO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
				try {
					// 1�ܰ� driver load�� �ѹ��� �ϸ��. 2~7�ܰ�
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);//3
					System.out.print("�Է��� �̸���?");
					pstmt.setString(1, scanner.next());
					System.out.println("�Է��� ����" + jobs + "��?");
					pstmt.setString(2, scanner.next());
					System.out.println("�����?");
					pstmt.setInt(3, scanner.nextInt());
					System.out.println("�����?");
					pstmt.setInt(4, scanner.nextInt());
					System.out.println("���д�?");
					pstmt.setInt(5, scanner.nextInt());
					int result =pstmt.executeUpdate(); //4,5
					System.out.println(result>0 ? "�Է¼���":"�Է½���");
					
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
				break;
			case "2": //������ �Է¹޾� ���
				sql = "SELECT ROWNUM RANK, A.*"
						+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ "    FROM PERSON P, JOB J"
						+ "    WHERE P.JNO=J.JNO AND JNAME=?"
						+ "    ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");//2
					pstmt = conn.prepareStatement(sql);//3
					System.out.println("����ϰ��� �ϴ� ������" + jobs + "?");
					pstmt.setString(1, scanner.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {// ������ ���
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank + "��\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�.");
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				break;
			case "3": //��ü ���
				sql = "SELECT ROWNUM RANK, A.*"
						+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ "    FROM PERSON P, JOB J"
						+ "    WHERE P.JNO=J.JNO"
						+ "    ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");//2
					pstmt = conn.prepareStatement(sql);//3
					rs = pstmt.executeQuery();
					if (rs.next()) {// ������ ���
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank + "��\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum);
						}while(rs.next());
					}else {
						System.out.println("����� ��ϵ��� �ʾҽ��ϴ�.");
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}while(fn.equals("1")|| fn.equals("2")|| fn.equals("3"));
		System.out.println("bye");
		
		
	}//main
}
