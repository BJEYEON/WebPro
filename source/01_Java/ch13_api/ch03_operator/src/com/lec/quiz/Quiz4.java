package com.lec.quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt(); // 키보드로부터 입력받은 정수를 age에 할당
		String str_Age = age>=65 ? "경로우대":"일반";
		System.out.println(str_Age);
		sc.close();
	}

}
