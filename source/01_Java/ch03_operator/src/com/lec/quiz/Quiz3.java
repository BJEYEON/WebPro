package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("수를 입력하세요 : ");
		int su = sc.nextInt(); // 키보드로부터 입력받은 정수를 su에 할당
		Scanner sc2 = new Scanner(System.in) ;
		System.out.print("두번째 수를 입력하세요 : ");
		int su2 = sc2.nextInt(); // 키보드로부터 입력받은 정수를 su2에 할당
		String str_Same =  su==su2 ? "두 수는 같습니다":"두 수는 다릅니다";
		System.out.println(str_Same);
		sc.close();
	}

}
