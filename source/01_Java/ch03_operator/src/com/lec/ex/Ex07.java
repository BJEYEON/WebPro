package com.lec.ex;
// 비트논리연산 : &(and), |(or)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 1; // 0 ~ 0 0 0 1
		int n2 = 2; // 0 ~ 0 0 1 0
		 //            ------------
		 //			&  0 ~ 0 0 0 0  (0)
		 //         |  0 ~ 0 0 1 1  (3)
		System.out.println("n1 & n2는" + (n1 & n2));
		System.out.println("n1 | n2는" + (n1 | n2));
	}

}
