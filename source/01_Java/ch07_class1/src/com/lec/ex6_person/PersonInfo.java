package com.lec.ex6_person;
// new PersonInfo("ȫ�浿", 22, 'm')
public class PersonInfo {
	private String name;
	private int age;
	private char gender;//'m'�Ǵ�f
	public PersonInfo() {} //����Ʈ ������ �Լ�
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("�̸�: " + name );
		System.out.println("����: " + age );
		System.out.println("����: " + gender ); //����m
		String str = (gender=='m' || gender=='M')? "��" : (gender=='f' ? "��":"-");
		System.out.println("����: " + str);//����:��
		
	}
	public String infoPrint() {
		String str = (gender=='m' || gender=='M')? "��" : (gender=='f' ? "��":"-");
			//String result = "�̸�: " + name + "\n����"
		String result = "�̸�: " + name;
		result += "\n����:" + age;
		result += "\n����:" + str;
		return result;
	}
}
