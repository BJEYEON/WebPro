package com.lec.ex;
// 자바는 대부분 1차원 배열을 씀
public class Ex06_multiDemension {
	public static void main(String[] args) {
		int[] arr = {1,2,3}; //1차원배열
		System.out.println(arr[2]);
		int[][] test = {{1,2,3},
						{4,5,6}};
		System.out.println(test[0][1]);
		//다차원 출력
		for(int i=0; i<test.length; i++) { //0~1행
			for (int j=0; j<test[i].length; j++) { //0~2행
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			}//for-j
		}//for-i
	}//main
}