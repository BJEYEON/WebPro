package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//스트림 객체 생성(FileReader -> bufferedReader) ->데이터를 읽는다(bufferdReader를 통해 한줄씩) ->파일을 닫는다(bufferedReader ->FileReader)
public class Ex01 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");// 1.기본스트림 생성
			br = new BufferedReader(reader);// 보조스트림은 기본스트림을 통해 생성
			while (true) {// 2. 데이터를 한줄씩 읽는다(br.readerLine())
				String linedata = br.readLine();
				if (linedata == null) {
					break;
				}
				System.out.println(linedata);
			}
			System.out.println("= = 파일입력끝 = =");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {// 3.스트림을 순서대로 닫는다
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
