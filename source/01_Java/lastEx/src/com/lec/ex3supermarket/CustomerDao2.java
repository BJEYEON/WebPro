package com.lec.ex3supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao2 {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL = 0;
	// DAO는 싱글톤 구현 = PRIVATE 생성자에는 DRIVER로드(1단계)
	private static CustomerDao2 INSTANCE;

	public static CustomerDao2 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao2();
		}
		return INSTANCE;
	}

	private CustomerDao2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		// ctel과 cname으로 customer insert (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)" + "    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}

//2. 폰뒤 4자리(풀번호)검색 (SEARCHTEL을 받아 CID, CNAME, CPOINT CAMOOUNT, LEVELNAME, FORLEVELUP)
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		// searchTel로 검색한 후에 dtos에 add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
				+ "    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) FORLEVELUP"
				+ "    FROM CUSTOMER C, CUS_LEVEL L\r\n" + "    WHERE C.LEVELNO=L.LEVELNO AND CTEL LIKE '%'||?"
				+ "    ORDER BY CAMOUNT DESC, CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
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

	// 3. 물품구입
	public int buy(int cid, int price) {
		int result = FAIL;
		// cid, price로 물품구매 update
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + "      SET CPOINT = CPOINT + (? * 0.05)," + "          CAMOUNT = CAMOUNT + ?,"
				+ "          LEVELNO = (SELECT L.LEVELNO" + "                        FROM CUSTOMER C, CUS_LEVEL L"
				+ "                        WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID= ?)" + "      WHERE CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		return result;
	}
	// 1. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
	public int insertCustomer(int price, int cid) {
		int result = FAIL;
		// ctel과 cname으로 customer insert (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME)" + "    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}

//	3번 물품구매 후 고객정보를 출력(CID, CTEL, CNAME,CPOINT, CAMOUNT, LEVELNAME, FORLEVELUP)
	public CustomerDto getCustomer(int cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
				+ "    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=5 AND CID=C.CID) FORLEVELUP"
				+ "    FROM CUSTOMER C, CUS_LEVEL L" + "    WHERE C.LEVELNO = L.LEVELNO AND CID=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {// 검색결과가 있는경우 cid가 있는경우, dto에 CustomerDto객체를 생성해서 할당
				// int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup);
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
		return dto;

	}

//4번 전 고객등급별 추출
	public ArrayList<String> getLevelNames() {
		ArrayList<String> levelNames = new ArrayList<String>();
		// 고객레벨이름들을 levelNames에 add
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// 검색결과가 있는경우 cid가 있는경우, dto에 CustomerDto객체를 생성해서 할당
				// int cid = rs.getInt("cid");
				levelNames.add(rs.getString("levelname"));
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
		return levelNames;
	}
//
////4번 고객등급별(등급이름) 출력 : levelName입력받아 CID, CNAME, CPOINT CAMOOUNT, LEVELNAME, FORLEVELUP
//	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
//		ArrayList<CustomerDto> levelNames = new ArrayList<CustomerDto>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME,"
//				+ "        (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) FORLEVELUP"
//				+ "        FROM CUSTOMER C, CUS_LEVEL L\r\n"
//				+ "        WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = UPPER(?)" + "        ORDER BY CAMOUNT DESC, CID";
//		try {
//			conn = DriverManager.getConnection(url, "scott", "tiger");
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, levelName);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int cid = rs.getInt("cid");
//				String ctel = rs.getString("ctel");
//				String cname = rs.getString("cname");
//				int cpoint = rs.getInt("cpoint");
//				int camount = rs.getInt("camount");
//				// String levelname = rs.getString("levelname");
//				int forlevelup = rs.getInt("forlevelup");
//				levelNames.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e2) {
//				System.out.println(e2.getMessage());
//			}
//		}
//		return levelNames;
//	}

	// 4번 고객등급별(등급이름) 출력
	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp"
				+ "  FROM CUSTOMER C, CUS_LEVEL L" + "  WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = UPPER(?)"
				+ "  ORDER BY CAMOUNT DESC, CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				// String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		return dtos;
	}

	// 5번 고객 전체 출력
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE LEVELNO!=5 AND CID=C.CID) forLevelUp"
				+ "  FROM CUSTOMER C, CUS_LEVEL L" + "  WHERE C.LEVELNO = L.LEVELNO " + "  ORDER BY CAMOUNT DESC, CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		return dtos;
	}

//6번 회원탈퇴: ctel 받아 delete
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		// ctel과 cname으로 customer insert (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL=?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			// pstmt.setString(2, cname);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
}
