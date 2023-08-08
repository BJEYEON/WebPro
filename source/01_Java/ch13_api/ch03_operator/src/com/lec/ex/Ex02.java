package com.lec.ex;
// 증감연산자 : ++(1증가), --(1감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; //n1을 1증가하고 n2에 할당
		System.out.println("n1=" + n1 + " n2=" + n2);
		n2 = ++n1;
		System.out.println("n1=" + n1 + " n2=" + n2);
		--n1; // n1을 1감소
		System.out.println("n1=" + n1);
		}

}
