package com.lec.ex;
// 1~10���� ������ �հ� �� ����� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for (int i=1; i<=10; i++) {
			tot += i;
		}//for
		System.out.println("1~10���� ������ ����" + tot);
		System.out.println( tot%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");
		//
		tot = 0;
		for (int i=11; i<=100; i++) {
			tot += i;
		}//for
		System.out.println("11~100���� ������ ����" + tot);
		System.out.println( tot%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");
		//11~100���� ������ �հ� �� ����� ¦������ Ȧ������ ���
	}

}
