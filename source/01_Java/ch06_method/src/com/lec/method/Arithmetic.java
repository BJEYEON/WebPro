package com.lec.method;
//sum(int,int), sum(int) - �Լ��� �����ε� /evevOdd(int) / abs(int)���밪
public class Arithmetic {
	public int sum(int from, int to) {//from����to���� �������� return
		int result = 0;
		for (int i=from; i<=to; i++) {
			result += i;
		}
		return result;
	}
	public int sum(int to) {//1~to���� ������return
		int result = 0;
		for (int i=1; i<=to; i++) {
			result += i;
		}
		return result;
	}
	public String evenOdd(int value) {
		String result = value%2 == 0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		return result;
	}
	public static int abs(int value) {//static���� ��Ű���޼ҵ常 �ۿ��� ��밡��
		int result = value>=0? value : -value; //���밪
		return result;
	}
}
