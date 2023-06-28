package com.lec.loop;
//break: 반복문을 빠져나감
public class Ex05_break_contiue {
	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			if (i==3) 
				//break;//반복문 빠져나감
				continue; //증감식으로 감>조건식
				System.out.println(i);
			//if
		}//for
	}//main

}
