package com.lec.ex10_final;
//speed, running, stop(�������̵� ����)
public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("�������� ������ ���� �پ��. ����ӵ�:" + speed);
	}

}
