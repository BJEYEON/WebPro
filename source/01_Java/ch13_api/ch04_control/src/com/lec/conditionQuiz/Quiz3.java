package com.lec.conditionQuiz;

import java.util.Scanner;

// 0(����), 1(����), 2(��)
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0(����), 1(����), 2(��) �� �����ϳ��� �����ϼ���:");
		int you = scanner.nextInt(); //0,1,2
		String str_you = (you==0) ? "����" : ( (you==1) ? "����":"���ڱ�");
		if (you>2 || you<0) {
			System.out.println("�߸���");
			System.exit(0);
		}
		System.out.println(str_you);
//		if (you==0) {
//			System.out.println("����");
//		}
//		else if (you==1) {
//			System.out.println("����");
//		}
//		else if (you==2) {
//			System.out.println("��");
//		}
//		else {
//			System.out.println("�߸���");
//		}
//		
//		switch (you) {
//		case 0: System.out.println("����"); break;
//		case 1: System.out.println("����"); break;
//		case 2: System.out.println("��"); break;
//		default: System.out.println("�߸��Է��Ͻ�"); break;
//		}
	}

}
