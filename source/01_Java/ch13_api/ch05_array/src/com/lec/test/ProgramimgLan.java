package com.lec.test;

//{76,45,34,89,100,50,90,93}  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요
public class ProgramimgLan {
	public static void main(String[] args) {
		int[] a_arr = { 76, 45, 34, 89, 100, 50, 90, 93 };
		int total = 0;
		int maxIdx = 0, max = 0;// 최대 구하기 위한 변수 (최대한 작은값)
		int minIdx = 0, min = 999; // 최소값을 구하기위한 변수
		for (int idx = 0; idx < a_arr.length; idx++) {
			if (a_arr[idx] < min) {
				min = a_arr[idx];
				minIdx = idx;
			} // if
			if (a_arr[idx] > max) {
				max = a_arr[idx];
				maxIdx = idx;
			}
		}
		
		for (int i = 0; i < a_arr.length; i++) {
			total += a_arr[i];
		} // for
		System.out.print("합계= " + total + '\t');
		System.out.printf("\t평균= %.2f", (double) total / a_arr.length);
		System.out.print("\r최대값은= " + a_arr[maxIdx] + "\t");
		System.out.print("최소값은= " + a_arr[minIdx]);

	}
}
