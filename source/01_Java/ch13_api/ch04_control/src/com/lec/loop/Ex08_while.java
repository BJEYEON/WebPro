package com.lec.loop;
/*
 * i�� 1�� �� �������� 1�̴�
		i�� 2�� �� �������� 3�̴�
		i�� 3�� �� �������� 6�̴�
		i�� 4�� �� �������� 10�̴�
 */
public class Ex08_while {
	public static void main(String[] args) {
		int tot = 0;
		int i=1;
		while(i<10) {
			tot += i;
			System.out.printf("i�� %d�� ������ �������� %d�̴�\n", i, tot);
			i++;
		}
//		for (int i=1; i<=10; i++) {
//			tot += i; //tot=tot+1
//			System.out.printf("i�� %d�� ������ �������� %d�̴�\n", i, tot);
//		}//for
	}//main

}
