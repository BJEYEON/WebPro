package com.lec.ex5_scanner;

import java.util.Scanner;

//�̸� (��ũ����|ȫ�浿) -> �ּ� -> ����
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�̸�?");
		String name = scanner.nextLine();
		System.out.println("�ּ�?");
		String address = scanner.nextLine();
		System.out.println("����?");
		int age = scanner.nextInt();
		System.out.println(age + "��" + name + "��" + address + "����");
	}

}
