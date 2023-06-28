package com.lec.condition;

import java.util.Scanner;

// 랜덤점수(0~100)를 학점 출력
public class Ex04_switch_hakjum {
	public static void main(String[] args) {
		//0<= Math.random() < 1난수 발생
		//0<= Math.random()*101 실수난수 발생
		//0<= (int)(Math.random() * 101)
		int score = (int)(Math.random() * 101);
		System.out.println("점수: " + score);
		//학점 출력
		switch(score/10) {
		case 10: case 9:
			System.out.println("A");break;
		case 8:
			System.out.println("B");break;
		case 7:
			System.out.println("C");break;
		case 6:
			System.out.println("D");break;
		default:
			System.out.println("F"); break;

		}
	
	}

}
