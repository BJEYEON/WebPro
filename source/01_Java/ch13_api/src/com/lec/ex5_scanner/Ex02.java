package com.lec.ex5_scanner;

import java.util.Scanner;

//���� - �̸� - �ּ�
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����?");
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴�" + age);
		System.out.print("�̸�?");
		scanner.nextLine();
		String name = scanner.nextLine();//��ũ����ȴ� white-space (space, tab, \n)�ձ��� ������. �Ǿտ� �ִ�\n����
		System.out.println("�Է��� �̸���" + name);
		System.out.print("�ּ�?");
		String address = scanner.nextLine();//\n\�ձ��� ������
		System.out.println("�Է��� �ּҴ�" + address);
		System.out.println("��");
	}

}
