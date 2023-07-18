package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//(1)스트림을 생성 (파일을 연다) (2)데이터를 읽는다(byte[]) 3. 파일을 닫는다
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("C:\\WebPro\\source\\01_Java\\ch16_io\\txtFile\\inTest.txt");//(1)스트림을 생성 (파일을 연다)상대경로, 절대경로 모두가능
			//(2)데이터를 읽는다(byte[])
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs); //bs배열만큼 읽고 읽은 byte 수를 리턴. 파일의 끝은 -1
				if (readByteCount == -1) break;
				for (int i=0; i<readByteCount; i++) {
					System.out.print((char)bs[i]);
					//System.out.printf("%3d/", bs[i]);
				}
				//System.out.println();//계행
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("읽기권한이 없거나 닫히지 않은경우" + e.getMessage());
		} finally {
			try {
				if (is!=null) is.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
			

	}
}
