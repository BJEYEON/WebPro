package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		String name = "";
		Scanner sc = new Scanner(System.in) ;
		System.out.print("���� �Է��ϼ��� : ");
		int su = sc.nextInt(); // Ű����κ��� �Է¹��� ������ su�� �Ҵ�
		String result = su%2 == 0? "¦���Դϴ�": "Ȧ���Դϴ�";
		System.out.println("�Է��Ͻż�(" + su + ")��" + result);
		sc.close();
	}

}