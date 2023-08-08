package com.lec.conditionQuiz;

import java.util.Scanner;

// 0(가위), 1(바위), 2(보)
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0(가위), 1(바위), 2(보) 중 숫자하나를 선택하세요:");
		int you = scanner.nextInt(); //0,1,2
		String str_you = (you==0) ? "가위" : ( (you==1) ? "바위":"보자기");
		if (you>2 || you<0) {
			System.out.println("잘못냄");
			System.exit(0);
		}
		System.out.println(str_you);
//		if (you==0) {
//			System.out.println("가위");
//		}
//		else if (you==1) {
//			System.out.println("바위");
//		}
//		else if (you==2) {
//			System.out.println("보");
//		}
//		else {
//			System.out.println("잘못냄");
//		}
//		
//		switch (you) {
//		case 0: System.out.println("가위"); break;
//		case 1: System.out.println("바위"); break;
//		case 2: System.out.println("보"); break;
//		default: System.out.println("잘못입력하심"); break;
//		}
	}

}
