package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

public class MemberDaoCP {
	public static final int MEMBER_EXISTENT = 0; // ID중복체크시 존재하는 ID일경우 RETURN값
	public static final int MEMBER_NONEXISTENT = 1; //사용가능한 ID일 경우RETURN값
	public static final int LOGIN_SUCCESS = 1; //로그인 성공시 RETURN값
	public static final int LOGIN_FAIL_PW = 0; //로그인 시 PW오류일때 RETURN값
	public static final int LOGIN_FAIL_ID = -1; //로그인 시 ID오류일때 RETURN값
	public static final int SUCCESS = 1; //회원가입, 회원정보 수정시 성공할때RETURN값
	public static final int FAIL = 0; //회원가입, 회원정보 수정시 실패할때RETURN값
	

	//connection객체를return
	private Connection getConnection() throws SQLException {
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
	//1. 회원가입시 ID중복체크: public int confirmID(String id)
	public int confirmID(String id) {
		int result = MEMBER_EXISTENT;//초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();//2
			pstmt = conn.prepareStatement(sql); //3
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //4+5
			if(rs.next()) {
				//중복된id를 검색
				result = MEMBER_EXISTENT;
			}else {
				//없는id(사용가능한id검색)
				result = MEMBER_NONEXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
		
	}
	//2. 회원가입 INSERT: public int join member(MemberDto dto)
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)" + 
				"    VALUES (?,?,?,?,?,?,?,?,?,?, SYSDATE )";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setDate(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//3. 로그인 : public int loginCheck(String id, String pw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_PW;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();//2
			pstmt = conn.prepareStatement(sql); //3
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //4+5
			if(rs.next()) {
				//유효한id를 입력한 경우
				String dbPw = rs.getString("pw"); //db에있는pw
				if(dbPw.equals(pw)) {//pw가 맞는지 체크하는if
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;
				}
			}else {
				//유효하지 않은id를 입력한 경우
				result = LOGIN_FAIL_ID;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//4. 로그인 성공시 SESSION에 SETATTRIBUTE할 회원정보(ID로 DTO가져오기) : public MemberDto getMember (String id)
	public MemberDto getmeMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();//2
			pstmt = conn.prepareStatement(sql); //3
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //4+5
			if(rs.next()) {
				String pw     = rs.getString("pw");
				String name   = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email  = rs.getString("email");
				Date   birth  = rs.getDate("birth");
				String address= rs.getString("address");
				Timestamp rdate = rs.getTimestamp("rdate");
				dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, address, rdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dto;
	}
	//5. 회원정보 수정 : public int modifyMember(MemberDto dto)
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER " + 
				"  SET PW = ?, " + 
				"      NAME = ?, " + 
				"      PHONE1 = ?, " + 
				"      PHONE2 = ?, " + 
				"      PHONE3 = ?, " + 
				"      GENDER = ?, " + 
				"      EMAIL = ?, " + 
				"      BIRTH = ?, " + 
				"      ADDRESS = ? " + 
				"  WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setDate(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "회원수정성공":"회원수정실패:"+dto);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원수정 실패 : " + dto);
		} finally {
			try {
				if(pstmt!= null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
		
	}


}
