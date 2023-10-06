package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao bDao = new BoardDao();
		int result = bDao.deleteBoard(bid);
		String deleteMsg = (result==BoardDao.SUCCESS) ? bid+ "번글 삭제 성공" : bid + "번글 삭제 실패";
		request.setAttribute("deleteMsg", deleteMsg);
	}

}
