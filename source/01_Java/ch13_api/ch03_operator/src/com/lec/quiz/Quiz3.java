package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("���� �Է��ϼ��� : ");
		int su = sc.nextInt(); // Ű����κ��� �Է¹��� ������ su�� �Ҵ�
		Scanner sc2 = new Scanner(System.in) ;
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		int su2 = sc2.nextInt(); // Ű����κ��� �Է¹��� ������ su2�� �Ҵ�
		String str_Same =  su==su2 ? "�� ���� �����ϴ�":"�� ���� �ٸ��ϴ�";
		System.out.println(str_Same);
		sc.close();
	}

}
