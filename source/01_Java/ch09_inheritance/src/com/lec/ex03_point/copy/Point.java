package com.lec.ex03_point.copy;
// 2���� ��ǥ��
public class Point {
	private int x;
	private int y;
	public Point() {
		System.out.println("�Ű����� ���� ���� Ŭ���� ������ �Լ�");
	}
	public Point(int x, int y) {
		System.out.println("�Ű������ִ� �θ�Ŭ���� ������ �Լ�- x,y�ʱ�ȭ");
		this.x = x;
		this.y = y;
	}
	public void infoPrint() {
		System.out.println("��ǥ(x,y) : " + x + ", " + y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
