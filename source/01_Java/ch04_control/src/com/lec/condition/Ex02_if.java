package com.lec.condition;

import java.util.Scanner;

//�μ��� �Է¹޾� ���° ���� �󸶸�ŭ �� ū�� ���
public class Ex02_if {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ����: ");
		int num1 = scanner.nextInt();
		System.out.print("�ι�° ����: ");
		int num2 = scanner.nextInt();
		if (num1>num2) {
			System.out.printf("ù��° ��(%d)�� %d��ŭ �� Ů�ϴ�\n", num1, (num1-num2));
		}
		else if (num2>num1) {
			System.out.printf("�ι�° ��(%d)�� %d��ŭ �� Ů�ϴ�\n", num2, (num2-num1));
		}
		else {
			System.out.println("�μ��� �����ϴ�");
		}
	}

}
