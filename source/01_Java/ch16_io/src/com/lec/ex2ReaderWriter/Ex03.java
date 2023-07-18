package com.lec.ex2ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// 파일이름과 파일 출력할 내용을 입력받아 해당 파일에 입력받은 내용을 출력(파일출력, 콘솔출력)
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer = null;
		System.out.println("저장할 파일이름은?");
		String fileName = scanner.next();// abc =>txtFile/abc.txt
		scanner.nextLine();// 버퍼 지우는용도
		try {
			writer = new FileWriter("txtFile/" + fileName + ".txt");
			while (true) {
				System.out.println("파일 출력할 내용은 (종료는x)?");
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("x"))
					break;
				writer.write(msg + "\n");
				System.out.println(msg);
			}
			System.out.println("txtFile/" + fileName + ".txt 파일로 출력 저장 완료");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
