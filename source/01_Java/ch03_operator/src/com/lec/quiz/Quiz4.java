package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt(); // Ű����κ��� �Է¹��� ������ age�� �Ҵ�
		String str_Age = age>=65 ? "��ο��":"�Ϲ�";
		System.out.println(str_Age);
		sc.close();
	}

}
