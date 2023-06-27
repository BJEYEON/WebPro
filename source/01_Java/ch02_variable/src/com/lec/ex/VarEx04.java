package com.lec.ex;

public class VarEx04 {
	public static void main(String[] args) {
		int i = 40; //4byte
		long l = 2200000000L; // 8byte
		System.out.println("l = " + l);
		boolean b = true;
		System.out.println("b = " + b);
		//소숫점은 double이 기본
		float f = 3.1415926539f;
		double d = 3.1415926539;
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		if (f == d) {
			System.out.println("f와d같다");
		}else {
			System.out.println("f와d다르다");
		}
		f = 10.1f;
		d = 10.1;
		double result = d + 1;
		System.out.println("d+1 =" + result );
		i = 3;
		//i(3) / 2 > 1.5
		System.out.println("i/2 = " + (i/2));
		System.out.println("(double)i/2 = " + ((double)i/2));
		System.out.println("i/2.0 = " + i/2.0);
	}

}
