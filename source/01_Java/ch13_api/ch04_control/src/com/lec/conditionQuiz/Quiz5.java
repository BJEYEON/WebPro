package com.lec.conditionQuiz;

import java.util.Scanner;

// ���� ���߱�
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ش���� �Է��� �ּ���.");
		int manth = scanner.nextInt(); // 1~12
		String str_Season = "";
		if (manth == 12 || manth >= 1 && manth < 3) {
			str_Season = "�ܿ��Դϴ�.";
		} else if (manth > 2 && manth < 7) {
			str_Season = "���Դϴ�.";
		} else if (manth > 6 && manth < 9) {
			str_Season = "�����Դϴ�.";
		} else if (manth > 8 && manth < 12) {
			str_Season = "�����Դϴ�.";
		} else {
			str_Season = "�߸��Է��߾��";
		}
		System.out.println(str_Season);
	}// main

}
