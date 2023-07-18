package com.lec.ex2ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

// �����̸��� ���� ����� ������ �Է¹޾� �ش� ���Ͽ� �Է¹��� ������ ���(�������, �ܼ����)
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Writer writer = null;
		System.out.println("������ �����̸���?");
		String fileName = scanner.next();// abc =>txtFile/abc.txt
		scanner.nextLine();// ���� ����¿뵵
		try {
			writer = new FileWriter("txtFile/" + fileName + ".txt");
			while (true) {
				System.out.println("���� ����� ������ (�����x)?");
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("x"))
					break;
				writer.write(msg + "\n");
				System.out.println(msg);
			}
			System.out.println("txtFile/" + fileName + ".txt ���Ϸ� ��� ���� �Ϸ�");
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
