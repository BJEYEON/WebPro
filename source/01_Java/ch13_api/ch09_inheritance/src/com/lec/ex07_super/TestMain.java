package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("�ƺ���"); papa.setCharacter("�׶���");
		papa.intro();
		Person mom = new Person("������", "������");
		mom.intro();
		Person child = new Baby();
		child.setName("�Ʊ��1"); child.setCharacter("�Ϳ���");
		child.intro();
		Baby child2 = new Baby("�Ʊ��2", "�ʹ� �Ϳ���");
		child2.intro();
		
	}
}
