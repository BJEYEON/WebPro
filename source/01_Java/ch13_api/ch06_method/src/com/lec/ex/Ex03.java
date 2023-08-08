package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절대값은: " + Arithmetic.abs(-9));
		Arithmetic arithmetic = new Arithmetic();//static없으면 써야댐
		int tot = arithmetic.sum(10);
		System.out.println("합은" + tot);
		System.out.println(arithmetic.evenOdd(tot));
		tot = arithmetic.sum(10, 100);
		System.out.println("합은" + tot);
		System.out.println(arithmetic.evenOdd(tot));
		
	}

}
