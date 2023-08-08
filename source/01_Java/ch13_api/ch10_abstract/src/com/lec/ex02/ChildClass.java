package com.lec.ex02;
//method1일반, method2,method3일반
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의method1 - 추상메소드라서 오버라이드 함");

	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("ChildClass의method2 - 걍 오버라이드 함");
	}
	public void method4() {
		System.out.println("ChildClass의 method4");
	}

}
