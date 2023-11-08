package com.lec.ch11.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch11.dao.BoardDao;
@Service
public class BListServie implements BService {
	@Autowired
	private BoardDao boardDao; //new안하고 이것만하면댐
	@Override
	public void execute(Model model) {
		// ${pageNum} 필요
		Map<String, Object> map = model.asMap(); //model을map으로 변경
		String pageNum = (String)map.get("pageNum");
		if(pageNum==null) pageNum = "1";
		final int PAGESIZE = 10, BLOCKSIZE=10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE -1;
		//BoardDao boardDao = new BoardDao();// 오토와이어드,서비스하면 안해도됨
		//뷰에 출력될 boardlist
		model.addAttribute("boardList", boardDao.listboBoard(startRow, endRow));
		int orderNum = startRow; //출력하게 될 순차번호
		int totCnt = boardDao.getBoardTotCnt(); //등록된 글갯수
		int inverseNum = totCnt - startRow + 1;// 첫라인에 출력하게 될 역순 번호
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("inverseNum", inverseNum);
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage -1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE-1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		// 뷰에 출력될 page관련변수
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("pageNum", currentPage);

	}

}
