package com.lec.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDao {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	// 싱글톤
	private static BookDao instance;
	public static BookDao getInstance() {
		if(instance==null) {
			instance = new BookDao();
		}
		return instance;
	}
	private BookDao() {};
	// 커넥션 풀에서 conn객체 가져와서 반환하는 함수 getConnection()
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 1. 책등록
	public int insertBook(BookDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, "
				+ "							bCONTENT, bDISCOUNT)"  
				+ "    VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setInt(2, dto.getBprice());
			pstmt.setString(3, dto.getBimage1());
			pstmt.setString(4, dto.getBimage2());
			pstmt.setString(5, dto.getBcontent());
			pstmt.setInt(6, dto.getBdiscount());
			result = pstmt.executeUpdate();
			if(result==SUCCESS) {
				System.out.println("책 등록 성공");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "-책 등록 실패/dto:" + dto);
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	// 2. 책목록(PAGING 없이)
	public ArrayList<BookDto> listBook(){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid          = rs.getInt("bid");
				String btitle    = rs.getString("btitle");
				int    bprice    = rs.getInt("bprice");
				String bimage1   = rs.getString("bimage1");
				String bimage2   = rs.getString("bimage2");
				String bcontent  = rs.getString("bcontent");
				int    bdiscount = rs.getInt("bdiscount");
				Timestamp brdate = rs.getTimestamp("brdate");
				books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "-책 등록 실패");
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return books;
	}
	// 2. 책목록(PAGING처리 : TOP-N)
	public ArrayList<BookDto> listBook(int startRow, int endRow){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM (SELECT ROWNUM RN, A.*" + 
				"        FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid          = rs.getInt("bid");
				String btitle    = rs.getString("btitle");
				int    bprice    = rs.getInt("bprice");
				String bimage1   = rs.getString("bimage1");
				String bimage2   = rs.getString("bimage2");
				String bcontent  = rs.getString("bcontent");
				int    bdiscount = rs.getInt("bdiscount");
				Timestamp brdate = rs.getTimestamp("brdate");
				books.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "- listBook");
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return books;
	}
	// 3. 등록된 책 갯수
	public int getBookTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "-책 등록 실패");
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return totalCnt;
	}
	// 4. 책상세보기(BID로 DTO가져오기)
	public BookDto getBook(int bid) {
		BookDto book = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String btitle    = rs.getString("btitle");
				int    bprice    = rs.getInt("bprice");
				String bimage1   = rs.getString("bimage1");
				String bimage2   = rs.getString("bimage2");
				String bcontent  = rs.getString("bcontent");
				int    bdiscount = rs.getInt("bdiscount");
				Timestamp brdate = rs.getTimestamp("brdate");
				book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "-책 등록 실패");
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return book;
	}
}
