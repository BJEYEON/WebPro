package com.lec.quiz;

import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("수학점수를 입력하세요 : "); // 수학점수 입력
		int math = sc.nextInt(); 
		
		Scanner sc2 = new Scanner(System.in) ;
		System.out.print("국어점수를 입력하세요 : "); // 국어점수 입력
		int kor = sc2.nextInt();
		
		Scanner sc3 = new Scanner(System.in) ;
		System.out.print("영어점수를 입력하세요 : "); //영어점수 입력
		int eng = sc3.nextInt();
		int total = math + kor + eng; // 각 점수 합구하기
		
		System.out.printf("\r\n수학점수=%d", math);
		System.out.printf("\r\n영어점수=%d", eng);
		System.out.printf("\r\n국어점수=%d", kor);
		System.out.println("\r\n총점:" + total + "점");
		System.out.printf("\r\n평군점수=%.2f", total/3.0); // 각점수 평균 구하고 소수 둘째자리까지 표기
		sc.close();
	}

}
