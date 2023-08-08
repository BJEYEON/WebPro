package com.lec.loopQuiz;
//원하는 구구단
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<10 ; i++) {
			System.out.println("원하는 구구단 수를 입력하세요.:");
			num = scanner.nextInt(); // 1~9
			if (num > 9 || num < 1) {
				System.out.println("잘못입력했습니다");
			}
				else if (num<=1 || num<=9) { 
					break;
				}
				
			}//for
	for(int j = 1;j<10;j++){
			System.out.printf("%d*%d=%d\t", num, j, num*j);
		}
}
// main
}