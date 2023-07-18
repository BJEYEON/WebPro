package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//��Ʈ�� ��ü ����(FileReader -> bufferedReader) ->�����͸� �д´�(bufferdReader�� ���� ���پ�) ->������ �ݴ´�(bufferedReader ->FileReader)
public class Ex01 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");// 1.�⺻��Ʈ�� ����
			br = new BufferedReader(reader);// ������Ʈ���� �⺻��Ʈ���� ���� ����
			while (true) {// 2. �����͸� ���پ� �д´�(br.readerLine())
				String linedata = br.readLine();
				if (linedata == null) {
					break;
				}
				System.out.println(linedata);
			}
			System.out.println("= = �����Է³� = =");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {// 3.��Ʈ���� ������� �ݴ´�
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
