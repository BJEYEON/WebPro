package com.lec.loop;
/*
 * i가 1일 때 누적합은 1이다
		i가 2일 때 누적합은 3이다
		i가 3일 때 누적합은 6이다
		i가 4일 때 누적합은 10이다
 */
public class Ex08_while {
	public static void main(String[] args) {
		int tot = 0;
		int i=1;
		while(i<10) {
			tot += i;
			System.out.printf("i가 %d일 때까지 누적합은 %d이다\n", i, tot);
			i++;
		}
//		for (int i=1; i<=10; i++) {
//			tot += i; //tot=tot+1
//			System.out.printf("i가 %d일 때까지 누적합은 %d이다\n", i, tot);
//		}//for
	}//main

}
