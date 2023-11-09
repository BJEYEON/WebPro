package com.lec.ch11.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.lec.ch11.vo.BoardDto;
@Repository //이거dao야 new 안해도됨
public class BoardDao {
	public static final int SUCCESS = 1;
	private final int FAIL = 0;// JSP에선 사용X
	@Autowired
	private JdbcTemplate jdbcTemplate;
//1. 글목록(startRow부터endRow)
	public ArrayList<BoardDto> listboBoard(final int startRow, final int endRow) {
		String sql = "SELECT * " + "    FROM (SELECT ROWNUM RN, A.*"
				+ "    FROM(SELECT * FROM MVCBOARD ORDER BY BGROUP DESC, BSTEP) A)" + "    WHERE RN BETWEEN ? AND ?";
		return (ArrayList<BoardDto>) jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
			}
		}, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}

//2. 글갯수
	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) CNT FROM MVCBOARD";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

//3. 원글쓰기 (bname, btitle, bcontent, bip, bgroup은 글번호, bstep과bindent는0)
	public int writeBoard(final BoardDto dto) {
		String sql = "INSERT INTO MVCBOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVCBOARD_SEQ.NEXTVAL, ?, ?, ?, MVCBOARD_SEQ.CURRVAL, 0, 0, ?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, dto.getBname());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setString(4, dto.getBip());
			}
		});
	}
//4. bid로 조회수 1올리기
	public void hitUp(int bid) {
		String sql = "UPDATE MVCBOARD SET BHIT = BHIT+1 WHERE BID="+ bid;
		jdbcTemplate.update(sql);
	}

//5. bid로 dto가져오기
	public BoardDto getBoardNotHitUp(int bid) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVCBOARD WHERE BID= " + bid;
		
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}

//6. 글수정 (특정bid의 bname, btitle, bcontent, bip 수정)
	
	public int modifyBoard(final BoardDto boardDto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVCBOARD" + "    SET BNAME = ?," + "        BTITLE = ?," + "        BCONTENT = ?,"
				+ "        BIP = ?" + "    WHERE BID=?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, boardDto.getBname());
				pstmt.setString(2, boardDto.getBtitle());
				pstmt.setString(3, boardDto.getBcontent());
				pstmt.setString(4, boardDto.getBip());
				pstmt.setInt(5, boardDto.getBid());
				
			}
		});
	}

//7. 글삭제 (특정 bid 삭제)
	public int deleteBoard(int bid) {
		
		String sql = "DELETE FROM MVCBOARD WHERE BID=" + bid;
		return jdbcTemplate.update(sql);
	}

//8. 답변글 저장 전단계(엑셀 a단계)
	private void preReplyStep(final int bgroup, final int bstep) {
	
		String sql = "UPDATE MVCBOARD SET BSTEP = BSTEP+1" + "    WHERE BGROUP=? AND BSTEP>?";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bgroup);
				pstmt.setInt(2, bstep);
				
			}
		});
	}

//9. 답변글 저장
	// 답변글쓴이 : bname, btitle, bcontent
	// 시스템으로 : bip
	// 원글정보:bgroup, bstep,bindent
	
	public int replyBoard(final BoardDto boardDto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVCBOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
				+ "    VALUES (MVCBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, boardDto.getBname());
				pstmt.setString(2, boardDto.getBtitle());
				pstmt.setString(3, boardDto.getBcontent());
				pstmt.setInt(4, boardDto.getBgroup());
				pstmt.setInt(5, boardDto.getBstep() + 1);
				pstmt.setInt(6, boardDto.getBindent() + 1);
				pstmt.setString(7, boardDto.getBip());
				
			}
		});
	}
}
