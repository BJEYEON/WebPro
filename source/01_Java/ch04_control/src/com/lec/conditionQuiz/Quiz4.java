package com.lec.conditionQuiz;

//가위바위보 게임
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0(가위), 1(바위), 2(보) 중 숫자하나를 선택하세요:");
		String str_End = "";
		int you = scanner.nextInt(); // 0,1,2
		int computer = (int) (Math.random() * 3);
		String str_you = (you == 0) ? "가위" : ((you == 1) ? "바위" : "보자기");
		String str_computer = (computer == 0) ? "가위" : ((computer == 1) ? "바위" : "보자기");
		if (you > 2 || you < 0) {
			System.out.println("잘못냄");
			System.exit(0);
		}
		if ((you + 2) % 3 == computer) {
			str_End = "이겼습니다.";
		} else if ((you + 1) % 3 == computer) {
			str_End = "졌습니다.";
		} else if (you == computer) {
			str_End = "비겼습니다.";
		}
		System.out.println("당신은" + str_you + ", 컴퓨터는" + str_computer + "\r\n" + str_End);
	}
}
