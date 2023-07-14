package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;// 사용자에게 입력받을 수 저장
		do {
			try {
		System.out.println("첫번째 정수는 (사칙연산 결과를 위한)?");
		i = scanner.nextInt();
		break;
			}catch (InputMismatchException e) {
				System.out.println("수에 문자를 넣지 마세요");
				scanner.nextLine();//\n앞까지 문자를return하고 \n을지우는 함수
			}
		}while (true);
		System.out.println("두번째 정수는 (사칙연산 결과를 위한");
		try {
			j = scanner.nextInt();
			System.out.println("i/j=" + (i / j));// 예외가 발생할 수도 있고, 안할수 있는부분
		} catch (ArithmeticException e) {// ArithmeticException 예외발생시 수행부분
			// e.printStackTrace();//좀 더 자세한 예외메세지
			System.out.println(e.getMessage());// 로그메세지
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());// 예외메세지
			System.out.println("두번째 정수를 잘못 입력하시면 무조건 1로 처리");
		}
		System.out.println("i*j=" + (i * j));
		System.out.println("i-j=" + (i - j));
		System.out.println("i+j=" + (i + j));
		System.out.println("DONE");
		scanner.close();

	}

}
