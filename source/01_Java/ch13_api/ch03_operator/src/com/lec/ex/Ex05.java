package com.lec.ex;
// 삼항연산자 a==b ? 조건이 true일 경우 취할값 : 조건이false일 경우 취할값
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
		//String result = h%2 == 0 ? "짝수입니다":"홀수입니다";
		String result;
		if (h%2 == 0) {
			result = "짝수입니다";
			}
		else {
			result = "홀수입니다";
		}
		System.out.println(result);
	}

}
