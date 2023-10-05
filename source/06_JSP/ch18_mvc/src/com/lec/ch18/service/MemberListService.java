package com.lec.ch18.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ch18.dao.MemberDao;
import com.lec.ch18.dto.MemberDto;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// dao를 통해서 멤버list가져와request에 set
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> memberList = mDao.listmemMember();
		request.setAttribute("memberList", memberList);
	}

}
