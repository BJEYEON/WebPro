package com.lec.condition;

import java.util.Scanner;

// 점수(0~100)를 입력받아 학점 출력
public class Ex04_switch_hakjum2_random {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수?");
		int score = sc.nextInt();
		int temp = score==100 ? 99:score;
		switch(temp/10) {
		case 9:
			System.out.println("A");break;
		case 8:
			System.out.println("B");break;
		case 7:
			System.out.println("C");break;
		case 6:
			System.out.println("D");break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F"); break;
		default:
			System.out.println("유효하지 않은 점수입니다");
			
		}
		sc.close();
	}

}
