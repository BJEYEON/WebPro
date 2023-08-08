package com.lec.ex;
// 일반for문vs. 확장for문(Array, ArrayList)
public class Ex02_out {
	public static void main(String[] args) {
		double[] arr = {999, 987, 920};
		//확장for문(배열 값만 출력)
		for(double a: arr) {
			System.out.println(a);
		}
		//일반for문(인덱스와 값을 같이 출력)
		for (int idx=0; idx<arr.length; idx++) {
			System.out.printf("arr[%d] = %.1f\t", idx, arr[idx]);
		}
		//배열 값을 변경
		System.out.println("10%증가"); 
//		for (double a : arr) { //array안의 값을 바꾸려면 foreach쓰면안댐
//			a *= 1.1;
//		}
		for (int idx=0; idx<arr.length; idx++) {
			arr[idx] *= 1.1; // arr[idx] = arr[idx] * 1.1;
		}
		for (double a : arr) {
			System.out.println(a + "\t");
		}
	}

}
