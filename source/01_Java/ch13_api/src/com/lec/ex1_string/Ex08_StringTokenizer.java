package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex08_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 고소영 장동건";
		String str2 = "100, 99, 85, 73";
		StringTokenizer token1 = new StringTokenizer(str1);// 구분자 " "
		StringTokenizer token2 = new StringTokenizer(str2, ", ");// 구분자 ", "
		while (token1.hasMoreElements()) {
			System.out.println(token1.nextToken());
		}
		while (token2.hasMoreElements()) {
			System.out.println(token2.nextElement());
		}
	}
	

}
