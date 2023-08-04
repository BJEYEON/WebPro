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
			Class.forName(driver);//1. 드라이버로드
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement(); // 3. sql전송객체
			rs = stmt.executeQuery(sql); // 4. sqp전송 + 5.전송결과받기
			//6. 전송결과에 따른 원하는 로직 수행
			if (rs.next()) { //select 문 결과가 1행이상
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
				do {
					//rs가 가르키는 곳의 empno, ename, job ,mgr 등등을가져와서 출력
					int empno = rs.getInt("empno");
					String ename = rs.getNString("ename");
					String job = rs.getNString("job");
					String mgr = rs.getString("mgr");
					Date hiredate = rs.getDate("hiredate"); // 날짜만 시간은 0시0분0초
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
			else { //select문 결과가 한행도 없는경우
				System.out.println("등록된 사원이 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {//7. 연결해제
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
