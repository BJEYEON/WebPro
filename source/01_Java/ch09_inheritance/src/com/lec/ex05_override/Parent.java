package com.lec.ex05_override;
//overloading - �Լ��� �ߺ�����
//override
public class Parent {
	public Parent() {//������ �Լ� �����ε�(�Լ��� �ߺ�����)
		System.out.println("�Ű����� ���� Parent ������");
	}
	public Parent(int i) {
		System.out.println("�Ű����� �ִ� Parent ������");
	}
	public void method1() {
		System.out.println("Parent��method1()�Լ�");
	}
	public void method2() {
		System.out.println("Parent��method2()�Լ�");
	}


}
