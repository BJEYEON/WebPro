package com.lec.ex07_super;
//super.
//super()
public class Person {
	private String name;
	private String character;
	public Person() {
		System.out.println("�Ű����� ����Person������");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("�Ű����� �ִ� Person������");
	}
	public void intro() {
		System.out.println("��" + name + "��" + character);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
