package com.lec.ex05_override;
// method1(), method2()
public class Child extends Parent {
	public Child() {//overload(�Լ��� �ߺ�����)
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i) {
		System.out.println("�Ű����� �ִ� Child ������ �Լ�");
	}
	@Override
	public void method1() {//override = �Լ��� ������
		System.out.println("Child�� method1()�Լ�");
	}
	public void method3() {
		System.out.println("Child�� method3()�Լ�");
	}
	@Override
	public boolean equals(Object obj) {
	return true;
	}
}
