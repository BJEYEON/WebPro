package com.lec.loop;
/*
**
***
****/
public class Ex03_for_star {
	public static void main(String[] args) {
		for (int i=1; i<6; i++) {
			for(int j=1; j<=i; j++) {// i번반복
				System.out.print("*");
				
			}
			System.out.println();//계행만
		}//for
	}//main

}
