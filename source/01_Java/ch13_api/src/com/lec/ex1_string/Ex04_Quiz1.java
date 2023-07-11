package com.lec.ex1_string;

import java.util.Scanner;

//<예제.주민번호를 입력받아 여자인지 남자인지 출력 예제> 주민번호는 “920225-2012121”형식으로 입력받는다.
public class Ex04_Quiz1 {
	public static void main(String[] args) {
		String num;
		Scanner scanner = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요.");
		num = scanner.next();
		System.out.println(Integer.parseInt(num.substring(7, 8)));
		if (num.indexOf("-") == -1 || Integer.parseInt(num.substring(7, 8)) >=5) {
			System.out.println("잘못입력했습니다.");
			
		}//if
		else if (Integer.parseInt(num.substring(7, 8)) == 1 ||Integer.parseInt(num.substring(7, 8)) == 3) {
			System.out.println("남자입니다.");
			
		}
		else if (Integer.parseInt(num.substring(7, 8)) == 2 ||Integer.parseInt(num.substring(7, 8)) == 4) {
			System.out.println("여자입니다");
		}
			
		
		
	}

}
