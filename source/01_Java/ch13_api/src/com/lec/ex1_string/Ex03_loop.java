package com.lec.ex1_string;

import java.util.Scanner;

//사용자가x를 입력할때 까지 무한반복
public class Ex03_loop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I:input, U:update, D:delte, X:exit?");
			fn = scanner.next();// i, I, U, u, d, d,x, X
			switch(fn) {
			case "i": case "I":
				System.out.println("입력로직"); break;
			case "u": case "U":
				System.out.println("업데이트 로직"); break;
			case "d": case "D":
				System.out.println("삭제로직");
			}
	//	}while (!fn.equals("x") && !fn.equals("X"));
		}while (!fn.equalsIgnoreCase("X"));
	}
}
