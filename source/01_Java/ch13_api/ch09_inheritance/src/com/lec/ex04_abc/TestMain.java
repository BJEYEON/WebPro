package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S();//s������ �Լ�
		//A aObj = new A(); 
		S aObj = new A(); //������ �Լ� 2������(�θ��,�ڽĴ�)
		//B bObj = new B();
		S bObj = new B();//������ �Լ� 2������(�θ��,�ڽĴ�)
		C cObj = new C();
		//S[] arr = {sObj,aObj,bObj,cObj, new C()};
		S[] arr = {sObj,aObj,bObj,cObj};
		for (int idx=0; idx<arr.length; idx++) {
			System.out.println(idx + "��°" + arr[idx].s);
		}
		for (S a : arr) {
			System.out.println("s=" + a.s);
		}
	}

}
