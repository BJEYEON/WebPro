package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부한 파일 저장 -> 파라미터 받아db수정(현비미런호에 따라-> 첨부한 파일을 소스폴더로 복사
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; //사진 업로드 제한 용량:1m
		String mphoto = ""; //첨부된 파일이름을 저장할 변수
		int result = MemberDao.FAIL; //db정보수정 결과를 저장할 변수
		try {
			MultipartRequest multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = multipartRequest.getFileNames(); //파라미터이름들
			//while(params.hasMoreElements()) {
				String param = params.nextElement(); //mphoto
				mphoto = multipartRequest.getFilesystemName(param);//첨부한 파일명
			//}
			// multipartRequest를 이용하여 파라미터를 받아와서db에 적용
			String dbMpw = multipartRequest.getParameter("dbMpw");
			String dbMphoto = multipartRequest.getParameter("dbMphoto");
			//hidden으로 넘어온 dbMpw, dbMphotork가 없을경우 session에서 가져오면됨
//			HttpSession session = request.getSession();
//			String dbMpw=null, dbMphoto=null;
//			MemberDto sessionMember = (MemberDto)session.getAttribute("member");
//			if(sessionMember!=null) {
//				dbMpw = sessionMember.getMpw();
//				dbMphoto = sessionMember.getMphoto();
//			}
			String mid = multipartRequest.getParameter("mid");
			String oldMpw = multipartRequest.getParameter("oldMpw");
			if(!oldMpw.equals(dbMpw)) { //
				request.setAttribute("modifyErrorMsg", "현비밀번호를 확인하세요");
				return;
			}
			String mpw = multipartRequest.getParameter("mpw");
			if(mpw.equals("")) { //정보수정시 새비밀번호를 입력하지 않은 경우 현 비밀번호
				mpw = dbMpw;
			}
			String mname = multipartRequest.getParameter("mname");
			String memail = multipartRequest.getParameter("memail");
			// 정보수정시 사진첨부 안하면, 기존의 사진(dbMphoto)으로
			mphoto = mphoto==null? dbMphoto: mphoto;
			String str_mbirth = multipartRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!str_mbirth.equals("")) {
				mbirth = Date.valueOf(str_mbirth);
			}
			String maddress = multipartRequest.getParameter("maddress");
			//db에 정보수정
			MemberDao mDao = MemberDao.getInstance();
			MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			result = mDao.modifyMember(mDto);
			if(result == MemberDao.SUCCESS) { //수정성공시, 세션도 수정
				HttpSession session = request.getSession();
				session.setAttribute("member", mDto);
				request.setAttribute("modifyResult", "회원정보 수정성공");
			}else {
				request.setAttribute("modifyErrorMsg", "회원정보 수정실패(mid check, 정보가 길거나)");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} //try-catch
		// 서버에 저장된 파일을 소스폴더로 복사(파일명이 NOIMG,JPG가 아니고나 result가 SUCCESS 인경우)
		File serverFile = new File(path + "/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") &&result==MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try{
					is = new FileInputStream(serverFile); //서버에 업로드된파일
					os = new FileOutputStream("C:\\WebPro\\source\\06_JSP\\ch18_mvcMember\\WebContent\\memberPhotoUp\\" + mphoto); //소스폴더로 복사될파일
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readByteCnt = is.read(bs);
						if(readByteCnt == -1)break;
						os.write(bs, 0, readByteCnt);
					}
					System.out.println(mphoto + "복사완료");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} //서버에 업로드 된 파일을 소스폴더로 복사
			}//if-파일복사여부
	}// excute함수
}//class
