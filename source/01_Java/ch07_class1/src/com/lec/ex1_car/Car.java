package com.lec.ex1_car;
// Ŭ���� -> ��ü(������,�޼ҵ�) Car car = new car();
public class Car {
	private String color;//��������
	private int		cc; //���� ��ⷮ
	private int		speed; //�����ӵ�
	public void park() {
		speed = 0;
		System.out.println(color + "�� �� ������. ���ݼӵ���" + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "�� �� ������. ���ݼӵ���" + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "�� �� ���̽���. ���ݼӵ���" + speed);
	}
	//color, cc, speed, setter&getter �޼ҵ�
	public void setColor(String color) {
		this.color = color;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//color, cc, speed getter
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
}
