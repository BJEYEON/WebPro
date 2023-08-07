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
		Statement stmt = null; //직업명들, 3번기능
		PreparedStatement pstmt = null;// 1번, 2번 기능
		ResultSet rs = null;
		Scanner scanner = new Scanner(System.in);
		String fn, sql;
		ArrayList<String> jobs = new ArrayList<String>(); // db에 있는 직업명들add
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
		//System.out.println("db에있는 직업명들" + jobs);
		do {
			System.out.println("1:입력 || 2:직업별조회 || 3:전체조회 || 그외:종료");
			fn = scanner.next();
			switch(fn) {
			case "1": //이름, 직업명, 국, 영, 수 입력받아 insert
				sql = "INSERT INTO PERSON "
						+ "VALUES (PERSON_PNO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
				try {
					// 1단계 driver load는 한번만 하면댐. 2~7단계
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);//3
					System.out.print("입력할 이름은?");
					pstmt.setString(1, scanner.next());
					System.out.println("입력할 직업" + jobs + "은?");
					pstmt.setString(2, scanner.next());
					System.out.println("국어는?");
					pstmt.setInt(3, scanner.nextInt());
					System.out.println("영어는?");
					pstmt.setInt(4, scanner.nextInt());
					System.out.println("수학는?");
					pstmt.setInt(5, scanner.nextInt());
					int result =pstmt.executeUpdate(); //4,5
					System.out.println(result>0 ? "입력성공":"입력실패");
					
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
			case "2": //직업명 입력받아 출력
				sql = "SELECT ROWNUM RANK, A.*"
						+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ "    FROM PERSON P, JOB J"
						+ "    WHERE P.JNO=J.JNO AND JNAME=?"
						+ "    ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");//2
					pstmt = conn.prepareStatement(sql);//3
					System.out.println("출력하고자 하는 직업명" + jobs + "?");
					pstmt.setString(1, scanner.next());
					rs = pstmt.executeQuery();
					if (rs.next()) {// 직업별 출력
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank + "등\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum);
						}while(rs.next());
					}else {
						System.out.println("해당 직업의 사람이 등록되지 않았습니다.");
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
			case "3": //전체 출력
				sql = "SELECT ROWNUM RANK, A.*"
						+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
						+ "    FROM PERSON P, JOB J"
						+ "    WHERE P.JNO=J.JNO"
						+ "    ORDER BY SUM DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");//2
					pstmt = conn.prepareStatement(sql);//3
					rs = pstmt.executeQuery();
					if (rs.next()) {// 직업별 출력
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							int rank = rs.getInt("rank");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank + "등\t" + pname + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum);
						}while(rs.next());
					}else {
						System.out.println("사람이 등록되지 않았습니다.");
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
