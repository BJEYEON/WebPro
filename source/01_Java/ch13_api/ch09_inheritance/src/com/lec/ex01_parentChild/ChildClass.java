package com.lec.ex01_parentChild;
//pstr, getPapaName(), getMamiNmae()
public class ChildClass extends ParentClass{
	public String cstr = "자식클래스";
	public ChildClass() {
		System.out.println("자식클래스의 생성자 함수");
	}
}
