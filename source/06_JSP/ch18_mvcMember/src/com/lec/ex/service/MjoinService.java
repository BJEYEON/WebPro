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

public class MjoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부한 파일 저장 -> 파라미터 받아db저장-> 첨부한 파일을 소스폴더로 복사
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; //사진 업로드 제한 용량:1m
		String mphoto = ""; //첨부된 파일이름을 저장할 변수
		int result = MemberDao.FAIL; //회원가입 결과를 저장할 변수
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
										new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); //파라미터 이름들
			//while(params.hasMoreElements()) {
				String param = params.nextElement();
				mphoto = mRequest.getFilesystemName(param);
			//}
			// mRequest를 이용하여 파라미터 받아와서db에 저장하기
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = mphoto==null? "NOIMG.JPG": mphoto;
			String str_mbirth = mRequest.getParameter("mbirth");
			Date mbirth = str_mbirth.equals("") ? null:Date.valueOf(str_mbirth); 
			String maddress = mRequest.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			// mid중복체크
			result = mDao.midConfirm(mid);
			if(result == MemberDao.NONEXISTENT) { //가입 가능한mid라서 회원가입진행
				MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				// 회원가입
				result = mDao.joinMember(newMember);
				if(result == MemberDao.SUCCESS) { //가입성공
					HttpSession session = request.getSession();
					session.setAttribute("mid", mid);
					request.setAttribute("joinResult", "회원가입이 완료되었습니다");
				}else { //가입실패
					request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
				}
			}else { //가입불가한mid
				request.setAttribute("joinErrorMsg", "중복된 id는 회원가입이 불가합니다");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("joinErrorMsg", "첨부파일의 용량 제한이1m");
		}
		// mRequest를 이용하여 파라미터 받아와서db에 저장하기 로직은 위에서
		// 서버에 업로드된 파일을 소스폴더로 복사
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
		}
	}// excute


