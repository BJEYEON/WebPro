package com.lec.ex07_super;
// private(name, character) public(intro(), setter,getter)
// super(): �θ� Ŭ������ ������ �Լ�
//this(): ���� Ŭ������ ������ �Լ�
//super.: �θ�Ŭ������
//this. : �� ��ü��
public class Baby extends Person{

	public Baby() {
		super();//�θ�Ŭ������ ������ �Լ� == Person()
		System.out.println("�Ű����� ���� Baby������");
	}
	public Baby(String name, String character) {
		super(name, character);// ==Person(name, character). Person()�������
//		setName(name);
//		setCharacter(character);
		System.out.println("�Ű����� �ִ� Baby������");
	}
	@Override
	public void intro() {
		System.out.println("������ ���� �̻۾Ʊ�");
		super.intro();//�θ� Ŭ������ intro()
	}
}
