package com.lec.ex10_final;

public class Animal {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("������ �ٰ� �־��. ���� �ӵ�:" + speed);
	}
	public final void stop() {//stop�޼ҵ�� override����
		speed = 0;
		System.out.println("����");
	}

}
