package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MvcTestDao;
import com.lec.ex.dto.MvcTestDto;

public class MjoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부한 파일 저장 -> 파라미터 받아db저장-> 첨부한 파일을 소스폴더로 복사
		int result = MvcTestDao.FAIL; //회원가입 결과를 저장할 변수
		// Request를 이용하여 파라미터 받아와서db에 저장하기
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String str_mbirth = request.getParameter("mbirth");
		Date mbirth = str_mbirth.equals("") ? null:Date.valueOf(str_mbirth); 
		String maddress = request.getParameter("maddress");
		MvcTestDao mDao = MvcTestDao.getInstance();
		// mid중복체크
		result = mDao.midConfirm(mid);
		if(result == MvcTestDao.NONEXISTENT) { //가입 가능한mid라서 회원가입진행
			MvcTestDto newMember = new MvcTestDto(mid, mpw, mname, memail, mbirth, maddress, null);
			// 회원가입
			result = mDao.joinMember(newMember);
			if(result == MvcTestDao.SUCCESS) { //가입성공
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
				request.setAttribute("joinResult", "회원가입이 완료되었습니다");
			}else { //가입실패
				request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
			}
		}else { //가입불가한mid
			request.setAttribute("joinErrorMsg", "중복된 id는 회원가입이 불가합니다");
		}
		
		// Request를 이용하여 파라미터 받아와서db에 저장하기 로직은 위에서
	}// excute
}


