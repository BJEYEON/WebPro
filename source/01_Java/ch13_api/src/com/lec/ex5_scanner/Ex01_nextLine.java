package com.lec.ex5_scanner;

import java.util.Scanner;

//���� - �̸� - �ּ�
public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����?");
		int age = scanner.nextInt();
		System.out.println("�Է��� ���̴�" + age);
		System.out.print("�̸�?");
		String name = scanner.next();//��ũ����ȴ� white-space (space, tab, \n)�ձ��� ������. �Ǿտ� �ִ�\n����
		System.out.println("�Է��� �̸���" + name);
		System.out.println("�ּ�?");
		scanner.nextLine();//�����ִ� \n�� ����� �뵵
		String address = scanner.nextLine();//\n\�ձ��� ������
		System.out.println("�Է��� �ּҴ�" + address);
		System.out.println("��");
	}

}
