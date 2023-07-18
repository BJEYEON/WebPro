package com.lec.ex3_bufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

// ����ڷκ��� ���� �̸��� �Է�(scanner) ->�ش����� �̸��� �����ϴ��� check�Լ� ->�ش� ������ console���
public class Ex02_filenameConsolePrint {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�о�� ���� ����?: ");// abc.txt -> txtFile/abc.txt
		String filename = scanner.next();
		File file = new File("txtFile/" + filename);
		if (file.exists()) {
			try {
				reader = new FileReader(file);// 1. ��Ʈ�� ����(�⺻��Ʈ��)
				br = new BufferedReader(reader);// �⺻��Ʈ���� ���� ������Ʈ�� ����
				while (true) {// 2. ������Ʈ���� ���� 1�پ� read
					String linedata = br.readLine();
					if (linedata == null)
						break;
					System.out.println(linedata);
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(br!=null) br.close();
					if(reader!=null)reader.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�");
		}
	}
}
