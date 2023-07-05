package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		Parent pObj1 = new Parent();
		Parent pObj2 = new Parent(10);
		System.out.println("�� ��ü�� ������?" + pObj1.equals(pObj2));
		pObj1.method1();
		pObj1.method2();
		pObj2.method1();
		System.out.println("--------------------");
		Child cObj1 = new Child();//Parent() -> Child()
		Child cObj2 = new Child(10);//Parent() -> Child(10)

		cObj1.method1();
		cObj1.method2();
		cObj2.method3();
		System.out.println("�� ��ücObj���� ������?" + cObj1.equals(cObj2));
		System.out.println("-----------------------");
		//Child obj = new Child();
		Parent obj = new Child();
		obj.method1();
		obj.method2();
		if (obj instanceof Child) {//obj�� ����Ű�� ���� child��ü���ִ�?
			((Child)obj).method3(); //��ü�� ������� ����ȯ obj->Child ������Parent
		}
		else {
			System.out.println("����ȯ �Ұ�");
		}
		
	}
}
