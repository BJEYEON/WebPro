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

public class MjoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부한 파일 저장(mRequest 객체 생성) -> 파라미터 받아 DB 저장  -> 첨부한 파일을 소스폴더로 복사
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024;//사진 업로드 제한용량
		String mphoto = ""; //첨부된 파일이름을 저장할 변수
		int result = MemberDao.FAIL; //회원가입 결과를 저장할 변수
		MultipartRequest multipartRequest = null;
		try {
			multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8");
			Enumeration<String> params = multipartRequest.getFileNames();//파라미터이름들
			//while(params.hasMoreElements()) {
				String param = params.nextElement();
				mphoto = multipartRequest.getFilesystemName(param);
				//}
				// mRequest를 이용하여 파라미터 받아와서 DB에 저장하기
				String mid = multipartRequest.getParameter("mid");
				String mpw = multipartRequest.getParameter("mpw");
				String mname = multipartRequest.getParameter("mname");
				String memail = multipartRequest.getParameter("memail");
				mphoto = multipartRequest.getParameter(param);
				String str_mbirth = multipartRequest.getParameter("mbirth");
				// Date mbirth = str_mbirth.equals("") ? null:Date.valueOf(str_mbirth);
				Date mbirth = null;
				if(!str_mbirth.equals("mbirth")) {
					mbirth = Date.valueOf("str_mbirth");
				}
				String maddress = multipartRequest.getParameter("maddress");
				MemberDao mDao = MemberDao.getInstance();
				MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				result = mDao.joinMember(newMember);
				if(result == MemberDao.SUCCESS) {//가입성공
					HttpSession session = request.getSession();
					session.setAttribute("mid", mid);
					request.setAttribute("joinResult", "회원가입이 완료되었습니다");
				}else { //가입실패
					request.setAttribute("joinErrorMsg", "정보가 너무길어서 회원가입실패");
				}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("joinErrorMsg", "첨부 파일의 용량은 1M 이내로 업로드 해주세요");
		}
		// mRequest를 이용하여 파라미터 받아와서 DB에 저장하기 로직은 위 try절에서
				// 서버에 업로드된 파일을 소스폴더로 복사
				File serverFile = new File(path + "/" + mphoto);
				if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result==MemberDao.SUCCESS) {
					InputStream is = null;
					OutputStream os = null;
					try{
						is = new FileInputStream(serverFile); // 서버에 업로드된 파일
						os = 
						new FileOutputStream("C:\\WebPro\\source\\07_jQuery\\model2ex\\WebContent\\memberPhotoUp"
									+ mphoto);
						byte[] bs = new byte[(int)serverFile.length()];
						while(true){
							int readByteCnt = is.read(bs);
							if(readByteCnt==-1) break;
							os.write(bs, 0, readByteCnt);
						}
						System.out.println(mphoto +" 복사 완료");
					}catch(Exception e){
						System.out.println(e.getMessage());
					}finally{
						try {
							if(os!=null) os.close();
							if(is!=null) is.close();
						}catch (IOException e) {
							System.out.println(e.getMessage());
						} // close
					} // try-catch-finally
				}// if-파일복사여부
	}

}
