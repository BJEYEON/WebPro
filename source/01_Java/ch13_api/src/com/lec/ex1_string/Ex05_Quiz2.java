package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tel;
		String tel2 = "";
		String tel3 = "";
		do {
			System.out.println("전화번호를 입력하세요.");
			tel = scanner.next(); // 02-234-5678
			System.out.println(tel);
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					tel2 += tel.charAt(i);
				}
			}
			for (int i = tel.length()-1; i >= 0; i--) {
				tel3 += tel.charAt(i);
			}
			
			System.out.println("짝수번째 문자열" + tel2);
			System.out.println("문자를 거꾸로" + tel3);
			System.out.println("전화번호 맨 앞자리는?" + tel.substring(0, tel.indexOf("-")));
			System.out.println("전화번호 맨 뒷자리는?" + tel.substring(tel.lastIndexOf("-")+1));
		} while (!tel.equalsIgnoreCase("X"));
	}

}
