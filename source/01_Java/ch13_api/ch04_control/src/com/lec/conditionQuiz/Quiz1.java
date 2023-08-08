package com.lec.conditionQuiz;

import java.util.Scanner;

// 사용자로부터 수를 입력받아 절대값 출력(ex-5면5)
public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
		int su = scanner.nextInt();
		if(su>=0) {
			System.out.println("입력하신수의 절대값은" + su);
		}
		else {
			System.out.println("입력하신수의 절대값은" + (-su));
		}
				scanner.close();
	}

}
