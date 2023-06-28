package com.lec.conditionQuiz;

import java.util.Scanner;

// 계절 맞추기
public class Quiz5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("해당월을 입력해 주세요.");
		int manth = scanner.nextInt(); // 1~12
		String str_Season = "";
		if (manth == 12 || manth >= 1 && manth < 3) {
			str_Season = "겨울입니다.";
		} else if (manth > 2 && manth < 7) {
			str_Season = "봄입니다.";
		} else if (manth > 6 && manth < 9) {
			str_Season = "여름입니다.";
		} else if (manth > 8 && manth < 12) {
			str_Season = "가을입니다.";
		} else {
			str_Season = "잘못입력했어요";
		}
		System.out.println(str_Season);
	}// main

}
