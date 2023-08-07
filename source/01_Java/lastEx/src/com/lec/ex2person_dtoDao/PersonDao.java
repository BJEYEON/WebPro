package com.lec.ex2person_dtoDao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static int SUCCESS = 1;
	private final static int FAIL = 0;
	private static PersonDao INSTANCE = new PersonDao();

	public static PersonDao getInstance() {
//		if(INSTANCE == null) {
//			INSTANCE = new PersonDao();
//		}
		return INSTANCE;

	}

	private PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} // 1단계에선 생성자에서 한번
	}

	// jname들을 arraylist<String>호 return함수
	public ArrayList<String> janameList() {
		ArrayList<String> jname = new ArrayList<String>();
		// 직업명들을 arrayList add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				jname.add(rs.getString("jname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return jname;
	}

	// 1번기능 dto(이름, 직업명, 국, 영, 수)를 받아 db insert하고 결과(1or0)를 return
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		// db에 insert
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO PERSON"
				+ " VALUES (PERSON_PNO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?,?,?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "입력성공" : "입력실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	// 2번 기능 jname을 받아 db에 select한 결과를 arratList<PersonDto>로 return
	public ArrayList<PersonDto> selectJname(String jname) {
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// db결과를 dtos에add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*"
				+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "    FROM PERSON P, JOB J\r\n" + "    WHERE P.JNO=J.JNO AND JNAME=?" + "    ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				//String jname = rs.getString("jname");
				int kor  = rs.getInt("kor");
				int eng  = rs.getInt("eng");
				int mat  = rs.getInt("mat");
				int sum  = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
		// 3번 기능db에 전체 select한 결과를 arraylist<PersonDto>로 return
	public ArrayList<PersonDto> selectALL(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		//db결과를 dtos에 add
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*"
				+ "    FROM (SELECT PNAME||'('||PNO||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM"
				+ "    FROM PERSON P, JOB J"
				+ "    WHERE P.JNO=J.JNO"
				+ "    ORDER BY SUM DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String pname = rs.getString("pname");
				String jname = rs.getString("jname");
				int kor  = rs.getInt("kor");
				int eng  = rs.getInt("eng");
				int mat  = rs.getInt("mat");
				int sum  = rs.getInt("sum");
				dtos.add(new PersonDto(rank, pname, jname, kor, eng, mat, sum));
			}
		} catch (SQLException e) {
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
		return dtos;
	}
}
