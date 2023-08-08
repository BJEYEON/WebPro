package com.lec.ex01_parentChild;
// ParentClass == Super Class == 부모클래스
public class ParentClass {
	public String pstr = "부모클래스";
	public ParentClass() {
		System.out.println("부모클래스의 생성자 함수");
	}
	public void getPapaName(){
		System.out.println("아빠이름: 홍길동");
	}
	public void getMamiName() {
		System.out.println("엄마이름: 김길숙");
	}

}
