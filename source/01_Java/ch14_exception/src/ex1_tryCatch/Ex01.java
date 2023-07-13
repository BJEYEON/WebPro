package ex1_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
			int i, j;//사용자에게 입력받을 수 저장
		System.out.println("첫번째 정수는 (사칙연산 결과를 위한)?");
		i = scanner.nextInt();
		System.out.println("두번째 정수는 (사칙연산 결과를 위한");
		j = scanner.nextInt();
		try {
		System.out.println("i/j=" + (i/j));//예외가 발생할 수도 있고, 안할수 있는부분
		}catch(ArithmeticException e) {//ArithmeticException 예외발생시 수행부분
			e.printStackTrace();//좀 더 자세한 예외메세지
			//System.out.println(e.getMessage());//로그메세지
			
		}
		System.out.println("i*j=" + (i*j));
		System.out.println("i-j=" + (i-j));
		System.out.println("i+j=" + (i+j));
		System.out.println("DONE");
		scanner.close();



		
	}

}
