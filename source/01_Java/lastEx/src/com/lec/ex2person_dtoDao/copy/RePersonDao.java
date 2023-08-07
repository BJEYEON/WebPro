package com.lec.ex2person_dtoDao.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.ex2person_dtoDao.PersonDaoTest;

public class RePersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static int SUCCESS = 1;
	private final static int FAIL = 0;
	private static RePersonDao INSTANCE = new RePersonDao();
	public static RePersonDao getInstance() {
		return INSTANCE;
	}
	private RePersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
public ArrayList<String> jnameList(){
	ArrayList<String> jname = new ArrayList<String>();
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
	}finally {
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
}
