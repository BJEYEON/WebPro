package com.lec.ch18.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ch18.dao.MemberDao;
import com.lec.ch18.dto.MemberDto;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터(id, pw, name, birth)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String str_birth = request.getParameter("birth"); // ""이나 "1999-12-12"
		Date birth = null;
		if(!str_birth.equals("")) { //생일을 입력한 경우
			birth = Date.valueOf(str_birth);
			//birth = Timestamp.valueOf(str_birth + "00:00:00");
		}
		MemberDto newMember = new MemberDto(id, pw, name, birth, null);//db에 받은값셋팅
		MemberDao mDao = MemberDao.getInstance(); //dao를 통해 멤버new멤버 가져오기
		int result = mDao.joinMember(newMember);//dao를 통해 멤버new멤버 가져오기
		request.setAttribute("joinResult", result);//memberList에서 날릴 메세지2
		//memberList에서 날릴 메세지1
		if (result == MemberDao.SUCCESS) {
			request.setAttribute("joinMsg", "가입성공");
		} else {
			request.setAttribute("joinMsg", "가입실패");
		}
		
	}

}
