package com.lec.conditionQuiz;

//���������� ����
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0(����), 1(����), 2(��) �� �����ϳ��� �����ϼ���:");
		String str_End = "";
		int you = scanner.nextInt(); // 0,1,2
		int computer = (int) (Math.random() * 3);
		String str_you = (you == 0) ? "����" : ((you == 1) ? "����" : "���ڱ�");
		String str_computer = (computer == 0) ? "����" : ((computer == 1) ? "����" : "���ڱ�");
		if (you > 2 || you < 0) {
			System.out.println("�߸���");
			System.exit(0);
		}
		if ((you + 2) % 3 == computer) {
			str_End = "�̰���ϴ�.";
		} else if ((you + 1) % 3 == computer) {
			str_End = "�����ϴ�.";
		} else if (you == computer) {
			str_End = "�����ϴ�.";
		}
		System.out.println("�����" + str_you + ", ��ǻ�ʹ�" + str_computer + "\r\n" + str_End);
	}
}
