package com.lec.ex;
// ���׿����� a==b ? ������ true�� ��� ���Ұ� : ������false�� ��� ���Ұ�
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
		//String result = h%2 == 0 ? "¦���Դϴ�":"Ȧ���Դϴ�";
		String result;
		if (h%2 == 0) {
			result = "¦���Դϴ�";
			}
		else {
			result = "Ȧ���Դϴ�";
		}
		System.out.println(result);
	}

}
