package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("���������� �Է��ϼ��� : "); // �������� �Է�
		int math = sc.nextInt(); 
		
		Scanner sc2 = new Scanner(System.in) ;
		System.out.print("���������� �Է��ϼ��� : "); // �������� �Է�
		int kor = sc2.nextInt();
		
		Scanner sc3 = new Scanner(System.in) ;
		System.out.print("���������� �Է��ϼ��� : "); //�������� �Է�
		int eng = sc3.nextInt();
		int total = math + kor + eng; // �� ���� �ձ��ϱ�
		
		System.out.printf("\r\n��������=%d", math);
		System.out.printf("\r\n��������=%d", eng);
		System.out.printf("\r\n��������=%d", kor);
		System.out.println("\r\n����:" + total + "��");
		System.out.printf("\r\n������=%.2f", total/3.0); // ������ ��� ���ϰ� �Ҽ� ��°�ڸ����� ǥ��
		sc.close();
	}

}
