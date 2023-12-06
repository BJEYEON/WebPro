package com.lec.ch18.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch18.repository.BookRepository;
import com.lec.ch18.util.Paging;
import com.lec.ch18.vo.Book;
@Service
public class BookServiceImpl implements BookService {
	String backupPath = "E:\\WebPro\\source\\09_spring\\ch18_bookUpMember_sch\\src\\main\\webapp\\bookimgFileUpload\\";
	@Autowired
	private BookRepository bookRepository;
	@Override
	public List<Book> mainList() {
		return bookRepository.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum, Book book) {
		Paging paging = new Paging(bookRepository.totCntBook(book), pageNum, 10, 10);
		//Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookRepository.bookList(book);
	}

	@Override
	public int totCntBook(Book book) {
		return bookRepository.totCntBook(book);
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookRepository.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookimgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파일이름두개
		String[] bimg = new String[2];
		int i = 0;
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i + "번째 파라미터 이름: " + param);
			MultipartFile mFile = mRequest.getFile(param); //파라미터의 파일객체
			bimg[i] = mFile.getOriginalFilename();//업로드한 파일명
			System.out.println(bimg[i]==null? "널" : bimg[i].equals("")? "첨부안해서 빈스트링":"첨부한파일이름은" + bimg[i]);
			// 첨부여부
			if(bimg[i]!=null && !bimg[i].equals("")) {
				//첨부함
				if(new File(uploadPath + bimg[i]).exists()) {
					//첨부파일과 같은 이름의 파일이 서버에 존재: 현재밀리세컨 + 파일이름
					bimg[i] = System.currentTimeMillis() + bimg[i];
				}//중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + bimg[i]));// 서버에 파일저장
					System.out.println("서버에 저장된 파일:" + uploadPath + bimg[i]);
					System.out.println("복사될 파일: " + backupPath + bimg[i]);
					boolean isUpload = filecopy(uploadPath + bimg[i], backupPath+bimg[i]);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}//if
			i++;
		}//while
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookRepository.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookimgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // 파일이름두개
		String[] bimg = new String[2];
		int i = 0;
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i + "번째 파라미터 이름: " + param);
			MultipartFile mFile = mRequest.getFile(param); //파라미터의 파일객체
			bimg[i] = mFile.getOriginalFilename();//업로드한 파일명
			System.out.println(bimg[i]==null? "널" : bimg[i].equals("")? "첨부안해서 빈스트링":"첨부한파일이름은" + bimg[i]);
			// 첨부여부
			if(bimg[i]!=null && !bimg[i].equals("")) {
				//첨부함
				if(new File(uploadPath + bimg[i]).exists()) {
					//첨부파일과 같은 이름의 파일이 서버에 존재: 현재밀리세컨 + 파일이름
					bimg[i] = System.currentTimeMillis() + bimg[i];
				}//중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + bimg[i]));// 서버에 파일저장
					System.out.println("서버에 저장된 파일:" + uploadPath + bimg[i]);
					System.out.println("복사될 파일: " + backupPath + bimg[i]);
					boolean isUpload = filecopy(uploadPath + bimg[i], backupPath+bimg[i]);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}//if
			i++;
		}//while
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookRepository.modifyBook(book);
	}
	private boolean filecopy(String serverFile, String backupFile) {//파일 복사가 될수도 있고 안될수도
		boolean isCopy = false;
		InputStream is = null;
		OutputStream os = null;
		File file = new File(serverFile);
		try {
			file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				int nReadBytes = is.read(bs);
				if(nReadBytes == -1) break;
				os.write(bs, 0, nReadBytes);
			}
			isCopy = true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(is!=null) is.close();
				if(os!=null) is.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//복사
		return false;
	}

}
