package com.lec.ex;
// 동등비교(관계)연산자 : ==, !=(다르다), >, >=, <, ,=

public class Ex03 {
	public static void main(String[] args) {
		int n1 = 10, n2 = 5;
		boolean result = (n1 == n2);
		System.out.printf("%d %s %d 는 %b\n", n1, "==", n2, result);
		result = (n1 != n2);
		System.out.printf("%d %s %d 는 %b\n", n1, "!=", n2, result);
		result = (n1 != n2);
		System.out.printf("%d %s %d 는 %b\n", n1, ">=", n2, result);
		
		result = !(n1 != n2); // !논리연산 ; 반대를의미
		System.out.printf("%d %s %d 반대는 %b\n", n1, "!=", n2, result);
	}

}
