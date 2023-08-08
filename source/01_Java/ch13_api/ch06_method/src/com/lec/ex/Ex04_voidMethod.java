package com.lec.ex;
// return이 없는 method, 매개변수가 없는 method
public class Ex04_voidMethod {
	public static void main(String[] args) {
		printLine();
		System.out.println("Hello, Java");
		printLine('~');
		System.out.println("Hello, oracle DB");
		printLine(15);
		System.out.println("Hello, World");
		Ex04_voidMethod ex = new Ex04_voidMethod();//이게 변수
	//	ex.printLine(21, '#');
	}
//	private void printLine(int cnt, char c) {//static없으면 위에 변수 만들어야댐
//		for (int i=0; i<cnt; i++) {
//			System.out.print(c);
//		}
////		System.out.println();
		
	//}
	private static void printLine(int cnt) {
		for (int i=0; i<cnt; i++) {
			System.out.print('-');
		}
		System.out.println();
		
	}
	private static void printLine(char c) {
		for (int i=0; i<20; i++) {
			System.out.print(c);
	}
		System.out.println();
	}
	private static void printLine() {
		for (int i=0; i<20; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	

}
