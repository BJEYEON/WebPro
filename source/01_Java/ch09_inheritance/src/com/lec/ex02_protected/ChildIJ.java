package com.lec.ex02_protected;
// ChildIJ child = new ChildIJ(10,20)
public class ChildIJ extends SuperIJ{
	private int total;
	public ChildIJ() {
		System.out.println("�Ű����� ���� ChildIJ������ �Լ�");
	}
	public ChildIJ(int i, int j) {
		System.out.println("�Ű����� �ִ� ChildIJ ������ �Լ� i,j�ʱ�ȭ");
		this.i = i;
		setJ(j);
	}
	public void sum() {
		total = i + getJ();
		System.out.println("i=" + i + ", j=" +getJ() + ",total=" + total);
	}
}

