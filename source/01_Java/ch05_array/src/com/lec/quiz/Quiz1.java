package com.lec.quiz;
//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시요.
public class Quiz1 {
	public static void main(String[] args) {
		int[] a_arr = {6,45,34,89,100,50,90,92};
		for(int i=0; i<a_arr.length-1; i++) {
			for (int j=i+1; j<a_arr.length; j++) {
				if (a_arr[i]>a_arr[j]) {
					int temp = a_arr[i];
					a_arr[i] = a_arr[j];
					a_arr[j] = temp;
				}//if
			}//for
		}//for
		for (int i=0; i<a_arr.length; i++) {
			System.out.println(i + "번째: " + a_arr[i]);
		}
	}//main

}
