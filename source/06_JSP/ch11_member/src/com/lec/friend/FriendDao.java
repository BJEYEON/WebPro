package com.lec.friend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDao {
	public static final int SUCCESS=1;
	public static final int FAIL=0;
	//connection객체return
	//싱글톤
	private static FriendDao instance = new FriendDao();
	public static FriendDao getInstance() {
		return instance;
	}
	private FriendDao() {}
	//getConnection()
	private Connection getconnConnection() throws SQLException{
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
			
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	//친구추가 public int inserrFriend(String name, String tel){}
	public int finish(FriendDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIENDS(FNUM, FNAME, FTEL)" + 
				"    VALUES(SEQ.NEXTVAL, ?, ?)";
		try {
			conn = getconnConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFname());
			pstmt.setString(1, dto.getFtel());
			result = pstmt.executeUpdate();
			System.out.println("친구입력성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("친구입력실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
	}
	//친구추가 public int inserrFriend(FriendDto dto){} ==수업방법
	//2. 친구리스트 public ArratList<FriendDto> listFriend(){}
	public ArrayList<FriendDto> friendList(){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIENDS ORDER BY FNUM";
		try {
			conn = getconnConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fnum = rs.getInt("fnum");
				String fname = rs.getString("fname");
				String ftel = rs.getString("ftel");
				FriendDto dto = new FriendDto();
				dto.setFnum(fnum);
				dto.setFname(fname);
				dto.setFtel(ftel);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
		return dtos;
		
	}
}
