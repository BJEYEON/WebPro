package com.lec.loop;
//1����10���� ������ 3�� ������� ���� ���
public class Ex09while {
	public static void main(String[] args) {
		int tot = 0;
		int i=1;
		while(i<=10) {
			if(i%3 != 0) {
				tot += i;
			}//if
			i++;
		}//while
		System.out.println("1~10���� 3�� ����� ��:" + tot);
	}///main

}
