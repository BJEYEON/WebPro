package com.lec.ex10_final;
// speed, running, stop()�������̵� ����
public final class Rabbit extends Animal { //Rabbit Ŭ������ ��ӱ���
	@Override
	public void running() {
		speed += 30;
		System.out.println("�䳢�� ���沱�� �پ��. ����ӵ�:" + speed);
	}
}
