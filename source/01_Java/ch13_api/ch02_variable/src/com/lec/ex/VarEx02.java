package com.lec.ex;

public class VarEx02 {
	public static void main (String[] args) {
		int i = 10;
		byte j = 127;
		double h = 10.15;
		System.out.println("i=" + i + "\t j" + j + "\t h=" + h);
		System.out.printf("i=%d\t j=%d\t h=%.3f\n", i, j, h);
		char c1 = 'A';
		char c2 = 'B';
		c2 = 'C';
		//����(%c), ���ڿ�(%s), ����(%d), �Ǽ�(�Ҽ���%f), boolean(%d)
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		System.out.printf("c1=%d \t c2=%d\n", (int)c1, (int)c2);
	}

}
