package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		String tel2 = "";
		String tel3 = "";
		do {
			System.out.println("��ȭ��ȣ�� �Է��ϼ���.");
			tel = scanner.next(); // 02-234-5678
			System.out.println(tel);
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					tel2 += tel.charAt(i);
				}
			}
			for (int i = tel.length()-1; i >= 0; i--) {
				tel3 += tel.charAt(i);
			}
			
			System.out.println("¦����° ���ڿ�" + tel2);
			System.out.println("���ڸ� �Ųٷ�" + tel3);
			System.out.println("��ȭ��ȣ �� ���ڸ���?" + tel.substring(0, tel.indexOf("-")));
			System.out.println("��ȭ��ȣ �� ���ڸ���?" + tel.substring(tel.lastIndexOf("-")+1));
		} while (!tel.equalsIgnoreCase("X"));
	}

}
