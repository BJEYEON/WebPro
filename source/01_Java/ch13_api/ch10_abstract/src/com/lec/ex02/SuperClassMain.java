package com.lec.ex02;

public class SuperClassMain {
	public static void main(String[] args) {
		SuperClass obj = new SuperClass() {
			
			@Override
			public void method1() {
				System.out.println("�͸�Ŭ������ method1");
			}
		};
		obj.method1();	
	}
}
