package com.lec.ch16.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch16.repository.BoardRepository;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	@Override
	public List<Board> boardList(Paging paging) {
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardRepository.boardList(board);
	}

	@Override
	public int getBoardTotCnt() {
		return boardRepository.getBoardTotCnt();
	}

	@Override
	public int boardWrite(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardWrite(board);
	}

	@Override
	public Board boardContent(int bid, String after) {
		if(after==null) {// after는  "u"(수정완료후)이거나 null(list에서 옴)
			boardRepository.boardHitUp(bid);
		}
		return boardRepository.getBoardDto(bid);
	}

	@Override
	public Board boardModifyReplyView(int bid) {
		return boardRepository.getBoardDto(bid);
	}

	@Override
	public int boardModify(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardModify(board);
	}

	@Override
	public int boardDelete(int bid) {
		return boardRepository.boardDelete(bid);
	}

	@Override
	public int boardReply(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		boardRepository.boardPreReplyStep(board);
		return boardRepository.boardReply(board);
	}

	@Override
	public void dummyData70Write() {
		for(int i=1; i<60; i++) {
			Board board = new Board();
			board.setBname("홍길동"+i);
			board.setBtitle("제목" + i);
			board.setBip("192.168.1." + i);
			int result = boardRepository.boardWrite(board);
			System.out.println(result==1? i+"번쨰 성공":i+"번쨰 실패");
		}

	}

}
