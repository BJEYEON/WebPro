package com.lec.ex;

//배열 복제
public class Ex04_arrayCopy {
	public static void main(String[] args) {
		int[] score = { 100, 20, 30, 40, 50 };
		int[] s = new int[score.length];
		System.arraycopy(score, 0, s, 0, score.length); //score를s에 카피할건데0번방부터0번방부터 score길이만큼
//		for (int i = 0; i < s.length; i++) {
//			s[i] = score[i];
//		}
		for (int i = 0; i < s.length; i++) {
			System.out.printf("score[%d]=%d\t s[%d=%d]\n", i, score[i], i, s[i]);
		}
		s[0] = 99;
		for (int i = 0; i < s.length; i++) {
			System.out.printf("score[%d]=%d\t s[%d=%d]\n", i, score[i], i, s[i]);
		}

	}
}
