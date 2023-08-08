package com.lec.ex0_janmuri;
//자바파일에 public class 한개씩 꼭 구현 이렇게 만들면안됌 분리해야됌
class PersonInfo{
	private String name;
	private int age;
	private char gender;
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름: " + name + ", 나이" + age + ", 성별" + gender);
	}
}
public class personTestMain {
	public static void main(String[] args) {
		PersonInfo person1 = new PersonInfo("홍길동", 22, 'm');
		person1.print();
	}

}
