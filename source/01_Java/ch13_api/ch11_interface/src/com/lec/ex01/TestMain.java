package com.lec.ex01;

import org.omg.CORBA.INTERNAL;

//Interface1:CONSTANT_NUM, method1(�߻�޼ҵ�)/
//Interface2:CONSTANT_STRING, method2(�߻�)
public class TestMain {
	public static void main(String[] args) {
		//InterfaceEx1 ex1 = new InterfaceEx1() {//�߻�Ŭ������ �������̽��� ��ü ���� �Ұ�. ���� Ÿ�����θ� ����
		ClassEx obj = new ClassEx();
		obj.method1();
		obj.method2();
		InterfaceEx1 obj1 = new ClassEx();
		obj1.method1();
		//obj1.method2();
		InterfaceEx2 obj2 = new ClassEx();
		obj2.method2();
		//obj2.method1();
		System.out.println("CONSTANT_NUM : " + InterfaceEx1.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : " + ClassEx.CONSTANT_NUM);
		System.out.println("CONSTANT_NUM : " + obj.CONSTANT_NUM);//static�� class�� ������õ
		System.out.println("CONSTANT_STRING :" + InterfaceEx2.CONSTANT_STRING);
		System.out.println("CONSTANT_STRING :" + ClassEx.CONSTANT_STRING);
	}

}
