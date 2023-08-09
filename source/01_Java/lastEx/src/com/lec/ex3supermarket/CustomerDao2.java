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
	// DAO�� �̱��� ���� = PRIVATE �����ڿ��� DRIVER�ε�(1�ܰ�)
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

	// 1. ȸ������(����ȭ�� ���̸��� �Է¹޾� INSERT)
	public int insertCustomer(String ctel, String cname) {
		int result = FAIL;
		// ctel�� cname���� customer insert (2~7�ܰ�)
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

//2. ���� 4�ڸ�(Ǯ��ȣ)�˻� (SEARCHTEL�� �޾� CID, CNAME, CPOINT CAMOOUNT, LEVELNAME, FORLEVELUP)
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		// searchTel�� �˻��� �Ŀ� dtos�� add
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

	// 3. ��ǰ����
	public int buy(int cid, int price) {
		int result = FAIL;
		// cid, price�� ��ǰ���� update
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
	// 1. ȸ������(����ȭ�� ���̸��� �Է¹޾� INSERT)
	public int insertCustomer(int price, int cid) {
		int result = FAIL;
		// ctel�� cname���� customer insert (2~7�ܰ�)
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

//	3�� ��ǰ���� �� �������� ���(CID, CTEL, CNAME,CPOINT, CAMOUNT, LEVELNAME, FORLEVELUP)
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
			if (rs.next()) {// �˻������ �ִ°�� cid�� �ִ°��, dto�� CustomerDto��ü�� �����ؼ� �Ҵ�
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

//4�� �� ����޺� ����
	public ArrayList<String> getLevelNames() {
		ArrayList<String> levelNames = new ArrayList<String>();
		// �������̸����� levelNames�� add
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {// �˻������ �ִ°�� cid�� �ִ°��, dto�� CustomerDto��ü�� �����ؼ� �Ҵ�
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
////4�� ����޺�(����̸�) ��� : levelName�Է¹޾� CID, CNAME, CPOINT CAMOOUNT, LEVELNAME, FORLEVELUP
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

	// 4�� ����޺�(����̸�) ���
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

	// 5�� �� ��ü ���
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

//6�� ȸ��Ż��: ctel �޾� delete
	public int deleteCustomer(String ctel) {
		int result = FAIL;
		// ctel�� cname���� customer insert (2~7�ܰ�)
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
