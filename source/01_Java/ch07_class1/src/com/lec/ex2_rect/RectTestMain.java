package com.lec.ex2_rect;

public class RectTestMain {
	public static void main(String[] args) {
		Rect r1 = new Rect(10, 5);
		Rect r2 = new Rect();
		Rect r3 = new Rect(7);
		System.out.println("r1: " + r1.getWidth() + "*" + r1.getHeight());
		System.out.println("r1�� ���̴�" + r1.area());
		
		System.out.println("r2: " + r2.getWidth() + "*" + r2.getHeight());
		System.out.println("r2�� ���̴�" + r2.area());
		
		System.out.println("r3: " + r3.getWidth() + "*" + r3.getHeight());
		System.out.println("r3�� ���̴�" + r3.area());
	}

}
