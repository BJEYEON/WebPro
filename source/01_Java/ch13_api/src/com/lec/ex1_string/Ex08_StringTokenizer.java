package com.lec.ex1_string;

import java.util.StringTokenizer;

public class Ex08_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "�ں��� ���� ���� ��ҿ� �嵿��";
		String str2 = "100, 99, 85, 73";
		StringTokenizer token1 = new StringTokenizer(str1);// ������ " "
		StringTokenizer token2 = new StringTokenizer(str2, ", ");// ������ ", "
		while (token1.hasMoreElements()) {
			System.out.println(token1.nextToken());
		}
		while (token2.hasMoreElements()) {
			System.out.println(token2.nextElement());
		}
	}
	

}
