package com.lec.ex06_this;
//this. :����ü��~
//this() : �� Ŭ������ ������ �Լ�
public class Friend {
	private String name;
	private String tel;

	private Friend() {
		System.out.println("�Ű����� ���� ������");
	}

	public Friend(String name) {
		this(); // Friend()������ �Լ�
		this.name = name;
		System.out.println("�Ű����� �ϳ��� ������");
	}

	public Friend(String name, String tel) {
		this(name); // Friend(name)������ �Լ�
		this.tel = tel;
		System.out.println("�Ű����� �ΰ��� ������");
	}
	public String infoString() {
		return name + " : " + tel;
	}

}
