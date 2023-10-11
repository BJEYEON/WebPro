package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MvcTestDao;
import com.lec.ex.dto.MvcTestDto;

public class MloginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 받아서dao를 통해loginCheck -> 세션처리
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MvcTestDao mDao = MvcTestDao.getInstance();
		int result = mDao.loginCheck(mid, mpw);
		if(result == MvcTestDao.SUCCESS) { //로그인성공
			HttpSession session = request.getSession();
			MvcTestDto member = mDao.getMember(mid);//로그인 한 사람의dto정보
			session.setAttribute("member", member);
		}else {
			request.setAttribute("loginErrorMsg", "아이디와 비밀번호를 확인하세요");
		}

	}

}
