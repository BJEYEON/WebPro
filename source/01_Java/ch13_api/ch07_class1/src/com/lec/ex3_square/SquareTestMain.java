package com.lec.ex3_square;

public class SquareTestMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		System.out.println("s1�� �Ѻ����̴�:" + s1.getSide());
		Square s2 = new Square(2);
		System.out.println("s2�� �Ѻ����̴�:" + s2.getSide());
		System.out.println("s1�� ���̴�:" + s1.area());
		s2.setSide(10);
		System.out.println("������s2�� ���̴�:" + s2.area());
	}
}
