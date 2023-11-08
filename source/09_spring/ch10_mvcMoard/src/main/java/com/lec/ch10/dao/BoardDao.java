package com.lec.ch10.dao;

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

import org.springframework.stereotype.Repository;

import com.lec.ch10.vo.BoardDto;
@Repository //이거dao야 new 안해도됨
public class BoardDao {
	public static final int SUCCESS = 1;
	private final int FAIL = 0;// JSP에선 사용X
	private DataSource ds; // 미리 데이터 소스를10개씩 만들어놈

	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

//1. 글목록(startRow부터endRow)
	public ArrayList<BoardDto> listboBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + "    FROM (SELECT ROWNUM RN, A.*"
				+ "    FROM(SELECT * FROM MVCBOARD ORDER BY BGROUP DESC, BSTEP) A)" + "    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dtos.add(new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip));
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

//2. 글갯수
	public int getBoardTotCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MVCBOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("CNT");

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
		return totCnt;
	}

//3. 원글쓰기 (bname, btitle, bcontent, bip, bgroup은 글번호, bstep과bindent는0)
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVCBOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVCBOARD_SEQ.NEXTVAL, ?, ?, ?, MVCBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBname());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBip());
			// pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글쓰기 실패");
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

	public int writeBoard(String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVCBOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVCBOARD_SEQ.NEXTVAL, ?, ?, ?, MVCBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			result = pstmt.executeUpdate();
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "원글쓰기 실패");
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

//4. bid로 조회수 1올리기
	public void hitUp(int bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVCBOARD SET BHIT = BHIT+1 WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			pstmt.executeUpdate();
			System.out.println(bid + "번글조회수 업");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "조회수업 실패");
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

	}

//5. bid로 dto가져오기
	public BoardDto getBoardNotHitUp(int bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVCBOARD WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				String bip = rs.getString("bip");
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent, bip);
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

//6. 글수정 (특정bid의 bname, btitle, bcontent, bip 수정)
	public int modifyBoard(int bid, String bname, String btitle, String bcontent, String bip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVCBOARD" + "    SET BNAME = ?," + "        BTITLE = ?," + "        BCONTENT = ?,"
				+ "        BIP = ?" + "    WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setString(4, bip);
			pstmt.setInt(5, bid);
			// pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글수정 성공" : "글번호(bid)오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글수정실패");
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
	public int modifyBoard(BoardDto boardDto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVCBOARD" + "    SET BNAME = ?," + "        BTITLE = ?," + "        BCONTENT = ?,"
				+ "        BIP = ?" + "    WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getBname());
			pstmt.setString(2, boardDto.getBtitle());
			pstmt.setString(3, boardDto.getBcontent());
			pstmt.setString(4, boardDto.getBip());
			pstmt.setInt(5, boardDto.getBid());
			// pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글수정 성공" : "글번호(bid)오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글수정실패");
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

//7. 글삭제 (특정 bid 삭제)
	public int deleteBoard(int bid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MVCBOARD WHERE BID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			// pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "글삭제 성공" : "글번호(bid)오류");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "글삭제실패");
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

//8. 답변글 저장 전단계(엑셀 a단계)
	private void preReplyStep(int bgroup, int bstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVCBOARD SET BSTEP = BSTEP+1" + "    WHERE BGROUP=? AND BSTEP>?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
			System.out.println("bstep재조정됨");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "preReplyStep오류");
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
	}

//9. 답변글 저장
	// 답변글쓴이 : bname, btitle, bcontent
	// 시스템으로 : bip
	// 원글정보:bgroup, bstep,bindent
	public int replyBoard(String bname, String btitle, String bcontent, String bip, int bgroup, int bstep,
			int bindent) {
		int result = FAIL;
		preReplyStep(bgroup, bstep);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVCBOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVCBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, bgroup);
			pstmt.setInt(5, bstep + 1);
			pstmt.setInt(6, bindent + 1);
			pstmt.setString(7, bip);
			//pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			System.out.println("답변쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변쓰기 실패");
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
	public int replyBoard(BoardDto boardDto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVCBOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVCBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getBname());
			pstmt.setString(2, boardDto.getBtitle());
			pstmt.setString(3, boardDto.getBcontent());
			pstmt.setInt(4, boardDto.getBgroup());
			pstmt.setInt(5, boardDto.getBstep() + 1);
			pstmt.setInt(6, boardDto.getBindent() + 1);
			pstmt.setString(7, boardDto.getBip());
			pstmt.executeUpdate();
			result = pstmt.executeUpdate();
			System.out.println("답변쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변쓰기 실패");
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
