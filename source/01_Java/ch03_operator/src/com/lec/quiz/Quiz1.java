package com.lec.quiz;

import java.util.Scanner;

// ����ڷκ��� ���� �Է¹��� ���� 3�� ������� ���θ� ���
public class Quiz1 {
	public static void main(String[] args) {
		String name = "";
		Scanner sc = new Scanner(System.in) ;
		System.out.print("���� �Է��ϼ��� : ");
		int su = sc.nextInt(); // Ű����κ��� �Է¹��� ������ su�� �Ҵ�
		String result = su%3 == 0? "3�ǹ���Դϴ�": "3�ǹ���� �ƴմϴ�";
		System.out.println("�Է��Ͻż�(" + su + ")��" + result);
		sc.close();
	}

}
