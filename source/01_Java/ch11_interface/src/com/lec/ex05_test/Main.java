package com.lec.ex05_test;

public class Main {
	public static void main(String[] args) {
		TestChildClass obj = new TestChildClass();
		System.out.println(obj.i11); // static��class�̸����� ���� ��õ
		System.out.println(I3.i1);
		System.out.println(TestClass.i1);
		System.out.println(TestChildClass.i1);
		obj.m1(); obj.m2(); obj.m3(); obj.m11();
		TestClass obj1 = obj;
		obj.m1(); obj.m2();obj.m3();
		//obj1.m11() �������ο���
	}

}
