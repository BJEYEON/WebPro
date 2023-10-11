package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mid = null;
		MemberDto sessMember = (MemberDto)session.getAttribute("member"); //로그인 한사람의dto
		if(sessMember != null) {
			mid = sessMember.getMid();
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.withdrawalMember(mid); //회원탈퇴
		if(result==MemberDao.SUCCESS) {
			request.setAttribute("withdrawalResult", "회원탈퇴가 완료되었습니다");
			session.invalidate(); //세션삭제
		}else {
			request.setAttribute("withdrawalResult", "로그인이 되어있지 않습니다");
		}
	}

}
