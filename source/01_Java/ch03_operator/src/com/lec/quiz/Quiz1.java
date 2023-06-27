package com.lec.quiz;

import java.util.Scanner;

// 사용자로부터 수를 입력받은 수가 3의 배수인지 여부를 출력
public class Quiz1 {
	public static void main(String[] args) {
		String name = "";
		Scanner sc = new Scanner(System.in) ;
		System.out.print("수를 입력하세요 : ");
		int su = sc.nextInt(); // 키보드로부터 입력받은 정수를 su에 할당
		String result = su%3 == 0? "3의배수입니다": "3의배수가 아닙니다";
		System.out.println("입력하신수(" + su + ")는" + result);
		sc.close();
	}

}
