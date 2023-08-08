package com.lec.ex2_rect;
// �ĺ���(Ŭ������, ��Ű����, ������): ���ĺ�, ����, _�����. ���ĺ����� ����
// Ŭ����: �Ӽ�(������, �ν���Ʈ����), �޼ҵ�, setter&getter
public class Rect {
	private int width;
	private int height;
	//������ �Լ�
	public Rect() {}// ����Ʈ ������ �Լ�(������ �Լ��� ������ �ڵ�����)
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
		
	}
	public Rect(int side) {
		width = height = side;
	}
	public int area() {//���̸� return
		return width * height;
	}
	//setter&getter
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeigth(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
