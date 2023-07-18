package com.lec.ex2ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_FileWriter {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/ex2ReaderWriter/outTest.txt",true);//(1)
//			char[] msg = {'안', '녕', ' ', 'H', 'i', '\n'};
//			for (char m : msg) {
//				writer.write(m);//(2)
//			}
			String msg = "안녕! Hi\n장마철 건강조심하세요\n";
			writer.write(msg);
			msg = "다음주까지 비온대요. 모두 뽀송뽀송\n";
			writer.write(msg);
			System.out.println("파일 출력완료");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer != null) {//(3)
					writer.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
