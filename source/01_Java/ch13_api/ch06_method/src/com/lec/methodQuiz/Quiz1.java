package com.lec.methodQuiz;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("원하는 구구단 수를 입력하세요.:");
			num = scanner.nextInt(); // 1~9
		} while (num > 9 || num < 0 );
		scanner.close();

		printLine(num);
	}

	private static void printLine(int cnt) {

		for (int j = 1; j < 10; j++) {
			System.out.printf("%d*%d=%d\t", cnt, j, cnt * j);
		}
	}
}
