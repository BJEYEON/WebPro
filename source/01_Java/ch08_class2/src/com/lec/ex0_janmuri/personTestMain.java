package com.lec.ex0_janmuri;
//�ڹ����Ͽ� public class �Ѱ��� �� ���� �̷��� �����ȉ� �и��ؾ߉�
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
		System.out.println("�̸�: " + name + ", ����" + age + ", ����" + gender);
	}
}
public class personTestMain {
	public static void main(String[] args) {
		PersonInfo person1 = new PersonInfo("ȫ�浿", 22, 'm');
		person1.print();
	}

}
