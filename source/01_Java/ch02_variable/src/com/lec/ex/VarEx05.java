package com.lec.ex;
//����ȯ
public class VarEx05 {
	public static void main(String[] args) {
		int i = 10; // 4byte
		double d = i; // d= 10.0; �������� ����ȯ 8byte
		System.out.println("d = " + d);
		i = (int)10.6; // ������� ����ȯ - ������ �ս��� ����� ����
		System.out.println("i = " + i);
	}

}
