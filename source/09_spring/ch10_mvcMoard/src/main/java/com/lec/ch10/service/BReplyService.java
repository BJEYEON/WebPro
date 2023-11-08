package com.lec.ch10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch10.dao.BoardDao;
import com.lec.ch10.vo.BoardDto;
@Service
public class BReplyService implements BService {
	@Autowired
	private BoardDao boarDao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto boardDto = (BoardDto)map.get("boardDto");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		boardDto.setBip(request.getRemoteAddr());
		//boardDto의 원글정보 : bid, bgroup, bstep, bindent
		// boardDto의 답변글 정보: bname, btitle, bcontent, bip
		model.addAttribute("replyResult", boarDao.replyBoard(boardDto));

	}

}
