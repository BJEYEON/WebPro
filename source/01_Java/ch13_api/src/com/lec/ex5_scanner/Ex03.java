package com.lec.ex5_scanner;

import java.util.Scanner;

//이름 (톰크루즈|홍길동) -> 주소 -> 나이
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름?");
		String name = scanner.nextLine();
		System.out.println("주소?");
		String address = scanner.nextLine();
		System.out.println("나이?");
		int age = scanner.nextInt();
		System.out.println(age + "살" + name + "님" + address + "거주");
	}

}
