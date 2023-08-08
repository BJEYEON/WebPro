package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S sObj = new S();//s생성자 함수
		//A aObj = new A(); 
		S aObj = new A(); //생성자 함수 2개실행(부모단,자식단)
		//B bObj = new B();
		S bObj = new B();//생성자 함수 2개실행(부모단,자식단)
		C cObj = new C();
		//S[] arr = {sObj,aObj,bObj,cObj, new C()};
		S[] arr = {sObj,aObj,bObj,cObj};
		for (int idx=0; idx<arr.length; idx++) {
			System.out.println(idx + "번째" + arr[idx].s);
		}
		for (S a : arr) {
			System.out.println("s=" + a.s);
		}
	}

}
