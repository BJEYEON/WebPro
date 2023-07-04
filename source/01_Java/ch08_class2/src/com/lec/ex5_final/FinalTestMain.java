package com.lec.ex5_final;

import com.lec.constant.Constant;

public class FinalTestMain {
	public static void main(String[] args) {
		//final double PI = 3.1415926535; //final변수(상수): 변경불가
		int r =3;
		double area = Constant.PI * r * r;
		double round = 2 * Constant.PI * r;
		System.out.printf("반지름이 %d인 원의 넓이는 %.3f\n", r, area);
		System.out.printf("반지름이 %d인 원의 둘레는 %.3f\n", r, round);

	}

}
