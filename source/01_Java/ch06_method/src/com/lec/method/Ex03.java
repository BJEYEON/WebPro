package com.lec.method;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9�� ������" + Arithmetic.abs(-9));
		Arithmetic ar = new Arithmetic();//static�Ⱦ��� �̰� �ؾߴ�
		int tot = ar.sum(11,100);
		System.out.println("11~100��������" + tot);
		System.out.println(ar.evenOdd(tot));
		tot = ar.sum(10);
		System.out.println("10������ ����" + tot);
	}

}
