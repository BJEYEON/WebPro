package com.lec.ex1_string;

import java.util.Scanner;

//��ȭ��ȣ ���ڸ��� �ߺ�x
public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-8888", "010-7777-7777" };
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("�˻��� ��ȭ��ȣ ���ڸ�:");
			String searchTel = scanner.next();// 6666
			if (searchTel.equalsIgnoreCase("x"))
				break;
			int i;
			for (i = 0; i < tels.length; i++) {
				int postIdx = tels[i].lastIndexOf("-");
				String postTel = tels[i].substring(postIdx + 1);
				if (postTel.equals(searchTel)) {
					System.out.println("�˻��Ͻ� ��ȭ��ȣ��" + tels[i]);
					break;
				}
			}
			if (i == tels.length) {
				System.out.println("�Է��Ͻ� ��ȭ��ȣ ���ڸ��� ������� �ʾҽ��ϴ�");
			}
		}
	}
}
