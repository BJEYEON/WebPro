package com.lec.ex3_math;
// Math.ceil-> double값 return(올림실수)
//Math.round(반올림할 실수) -> long값 return
//Math.floor(내릴실수)-> double값return 
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("8.01을 올림:" + (int)Math.ceil(8.15));
		System.out.println("8.15를 반올림" + Math.round(8.15));
		System.out.println("8.15를 버림:" + (int)Math.floor(8.15));
		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		System.out.println("8.15를 올림:" + Math.ceil(8.15*10)/10);
		System.out.println("8.15를 반올림:" + Math.round(8.15*10)/10.0);
		System.out.println("8.15를 버림:" + Math.floor(8.15*10)/10);
		System.out.println("일의 자리에서 반올림, 올림, 버림(85->90)");
		System.out.println("85를올림:" + (int)Math.ceil(85/10.0)*10);
		System.out.println("85를 반올림:" + Math.round(85/10.0)*10);
		System.out.println("85를 버림:" + (int)Math.floor(85/10.0)*10);
	}

}
