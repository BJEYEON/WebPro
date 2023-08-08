package com.lec.ex05_override;
//overloading - 함수의 중복정의
//override
public class Parent {
	public Parent() {//생성자 함수 오버로딩(함수의 중복정의)
		System.out.println("매개변수 없는 Parent 생성자");
	}
	public Parent(int i) {
		System.out.println("매개변수 있는 Parent 생성자");
	}
	public void method1() {
		System.out.println("Parent의method1()함수");
	}
	public void method2() {
		System.out.println("Parent의method2()함수");
	}


}
