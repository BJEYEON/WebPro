package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;// ����ڿ��� �Է¹��� �� ����
		do {
			try {
		System.out.println("ù��° ������ (��Ģ���� ����� ����)?");
		i = scanner.nextInt();
		break;
			}catch (InputMismatchException e) {
				System.out.println("���� ���ڸ� ���� ������");
				scanner.nextLine();//\n�ձ��� ���ڸ�return�ϰ� \n������� �Լ�
			}
		}while (true);
		System.out.println("�ι�° ������ (��Ģ���� ����� ����");
		try {
			j = scanner.nextInt();
			System.out.println("i/j=" + (i / j));// ���ܰ� �߻��� ���� �ְ�, ���Ҽ� �ִºκ�
		} catch (ArithmeticException e) {// ArithmeticException ���ܹ߻��� ����κ�
			// e.printStackTrace();//�� �� �ڼ��� ���ܸ޼���
			System.out.println(e.getMessage());// �α׸޼���
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());// ���ܸ޼���
			System.out.println("�ι�° ������ �߸� �Է��Ͻø� ������ 1�� ó��");
		}
		System.out.println("i*j=" + (i * j));
		System.out.println("i-j=" + (i - j));
		System.out.println("i+j=" + (i + j));
		System.out.println("DONE");
		scanner.close();

	}

}
