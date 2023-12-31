package com.lec.ex1_InputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//C:\WebPro\lecNote/bts_7.mp4
public class Ex4_FileCopyStep3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();// 1970부터 시작시점
		// file copy로직
		InputStream is = null;
		OutputStream os = null;
		File file = new File("C:\\WebPro\\lecNote/bts_7.mp4");
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream("C:\\WebPro\\lecNote/bts_copy.mp4");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];
			while (true) {//read&writ:7,46,513,2
				int readByteCount = is.read(bs);//read
				if (readByteCount == -1)
					break;
				os.write(bs, 0, readByteCount);// write
				cnt++;
//				if (cnt % 1000 == 0) {
//					System.out.println(cnt + "/7,460,545" + (int) (cnt / 7460545.0 * 100) + "%진행");
//				}
				
			}
			System.out.println(cnt + "번 실행함");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		long end = System.currentTimeMillis(); // 1970부터 끝나는 시점
		System.out.println((end - start) / 1000.0 + "초 걸림");
	}

}
