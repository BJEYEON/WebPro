package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) {
		SuperClass obj = new ChildClass();//�߻�Ŭ����(SuperClass)�� Ÿ�����θ� ����, ��ü������ �Ұ�
		obj.method1();
		obj.method2();
		obj.method3();
		//obj.method4(); //obj�� Ÿ���� supertclass�� Ÿ���̶� ������ ����
		if (obj instanceof ChildClass) {
			((ChildClass)obj).method4();
		}
	}

}
