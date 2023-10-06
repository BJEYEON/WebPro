package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// pageNum파라미터 받아startRow, endRow, startPage, endPage계산 dao를 통해list
		//list.do나list.do?pageNum=11
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE=10;
		int startRow = (currentPage -1)* PAGESIZE +1;
		int endRow = startRow + PAGESIZE - 1;
		BoardDao bDao = new BoardDao(); //싱글톤x
		request.setAttribute("list", bDao.listboBoard(startRow, endRow)); //글목록 뷰페이지(list.do)로 전달
		int totCnt = bDao.getBoardTotCnt(); //글갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); //전체페이지수
		int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); //이전을 출력할지 여부
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("pageCnt", pageCnt);//다음을 출력할지 여부

	}

}
