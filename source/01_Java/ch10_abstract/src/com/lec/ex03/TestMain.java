package com.lec.ex03;

import com.lec.ex02.SuperClass;

/*SuperCLass(�߻�) :method1, method2, method3
 *      ��
 * ChildAbstractClass(�߻�Ŭ����): method1,method2,method3,method4
 *       ��
 * GrandChild(�Ϲ�Ŭ����): method1,method2,method3,method4
 */
public class TestMain {
	public static void main(String[] args) {
		SuperClass obj1 = new GrandChild();
		obj1.method1();
		obj1.method2();
		obj1.method3();
		//obj1.method4();
		ChildAbstractClass obj2 = new GrandChild();
		obj2.method1();
		obj2.method2();
		obj2.method3();
		obj2.method4();
	}

}
