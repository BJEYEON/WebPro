package com.lec.method;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9의 절댓값은" + Arithmetic.abs(-9));
		Arithmetic ar = new Arithmetic();//static안쓰면 이거 해야댐
		int tot = ar.sum(11,100);
		System.out.println("11~100누적합은" + tot);
		System.out.println(ar.evenOdd(tot));
		tot = ar.sum(10);
		System.out.println("10까지의 합은" + tot);
	}

}
