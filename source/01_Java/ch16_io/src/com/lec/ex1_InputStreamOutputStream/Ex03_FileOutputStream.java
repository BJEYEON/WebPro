package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//파일을 연다(스트림 객체생성) ->쓴다 ->파일을 닫는다
public class Ex03_FileOutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); //기본false(파일이 없으면 생성.파일이 있으면 덮어씀)//true: 추가됌
	//		byte[] bs = {'h', 'e', 'l', 'l', 'o', '\n'};
			String msg = "Hi. Java\n01234567\n안녕";
			byte[] bs = msg.getBytes();// 스트링을 바이트로 바꿈
//			for (int i=0; i<bs.length; i++) {
//				os.write(bs[i]);
//			}//for
			os.write(bs);
			System.out.println("파일 출력완료");
		} catch (FileNotFoundException e) {
			System.out.println("폴더 못찾음. 예외메세지: " + e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(os!=null) os.close();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}//main

}
