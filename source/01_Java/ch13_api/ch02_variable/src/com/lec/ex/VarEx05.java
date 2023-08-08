package com.lec.ex;
//형변환
public class VarEx05 {
	public static void main(String[] args) {
		int i = 10; // 4byte
		double d = i; // d= 10.0; 묵시적인 형변환 8byte
		System.out.println("d = " + d);
		i = (int)10.6; // 명시적인 형변환 - 데이터 손실이 생길수 있음
		System.out.println("i = " + i);
	}

}
