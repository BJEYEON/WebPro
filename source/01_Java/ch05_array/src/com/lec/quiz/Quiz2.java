package com.lec.quiz;
//�迭�� ��� ���� ���ϴ� ���α׷��� �ۼ�int[] arr =  { 10, 20, 30, 40, 50}  
public class Quiz2 {
	public static void main(String[] args) {
		int total = 0;
		int[] a_arr =  {10, 20, 30, 40, 50};
		for (int i=0; i<a_arr.length; i++) {
			total += a_arr[i];
		}//for
		System.out.println(total);
	}//main

}
