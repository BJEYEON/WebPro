package com.lec.ex4_printWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

// printWriter : OutputStream을 기본 스트림으로 하는 보조 스트림
//BufferedReader : Reader를 기본 스트림으로 하는 보조스트림
//printWriter 혼자 기본스트림처럼 사용
public class Ex {
	public static void main(String[] args) {
		OutputStream os = null;
		Writer writer = null;
		PrintWriter printWriter = null;
		try {
			//1. PrintWriter : OutputStream의 보조 스트림
//			os = new FileOutputStream("txtFile/outTest.txt",true);
//			printWriter = new PrintWriter(os);
			
			//2. printWriter: Writer의 보조스트림
//			writer = new FileWriter("txtFile/outTest.txt",true);
//			printWriter = new PrintWriter(writer);
			
			//3. PrintWrite를 기본 스트림처럼 사용
			printWriter = new PrintWriter("txtFile/outTest.txt");
			//콘솔및 파일 출력
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\n반갑습니다");
			System.out.print("print는 자동개행이 안돼요. 그래서 계행추가\n");
			printWriter.print("print는 자동개행이 안돼요. 그래서 계행추가\n");
			System.out.printf("%s %3d %3d %5.1f\n", "홍길동", 100,100,100.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "홍길동", 100,100,100.0);
			System.out.printf("%s %3d %3d %5.1f\n", "신길동", 90,91,90.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "신길동", 90,91,90.5);
			System.out.printf("%s %3d %3d %5.1f\n", "박길동", 95,97,96.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "박길동", 95,97,96.0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if (printWriter!=null) printWriter.close();
				if (os!=null) os.close();
				if (writer!=null) writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
