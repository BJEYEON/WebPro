package com.lec.ex2_access;

public class AccessTest {
	private int privateMember; //���� Ŭ���� �������� ���
	int defultMember; // ����Ʈ ��������: ���� ��Ű�������� ���
	protected int protectedMember; // ���� ��Ű���� ��ӹ��� Ŭ�������� ���
	public	  int publicMember; //�ƹ������� ���
	private void privateMethod() {
		System.out.println("private �޼ҵ�/ privateMember:" + privateMember);
	}
	void defaultMethod() {
		System.out.println("����Ʈ �������� �޼ҵ�");
	}
	protected void protectedMethod() {
		System.out.println("protected �޼ҵ�");
	}
	public void publicMethod() {
		System.out.println("public �޼ҵ�");
	}

	
}
