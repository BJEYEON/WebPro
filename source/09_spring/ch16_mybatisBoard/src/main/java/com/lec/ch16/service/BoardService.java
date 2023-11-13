package com.lec.ch16.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;

public interface BoardService { // ip를 사용자로부터 안받고 입력되게 하려면 reqeust로 받음ip사용안하면dao랑 똑같음
	public List<Board> boardList(Paging paging);
	public int getBoardTotCnt();
	public int boardWrite(Board board, HttpServletRequest request);
	public Board boardContent(int bid, String after);
		//수정 후 content.dp?after=u
	public Board boardModifyReplyView(int bid);
	public int boardModify(Board board, HttpServletRequest request);
	public int boardDelete(int bid);
	public int boardReply(Board board, HttpServletRequest request);	
	public void dummyData70Write();

}
