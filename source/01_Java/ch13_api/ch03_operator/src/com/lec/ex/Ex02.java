package com.lec.ex;
// ���������� : ++(1����), --(1����)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; //n1�� 1�����ϰ� n2�� �Ҵ�
		System.out.println("n1=" + n1 + " n2=" + n2);
		n2 = ++n1;
		System.out.println("n1=" + n1 + " n2=" + n2);
		--n1; // n1�� 1����
		System.out.println("n1=" + n1);
		}

}
