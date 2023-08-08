package com.lec.loopQuiz;
//1부터10까지 홀수 누적합
public class Quiz4 {
	public static void main(String[] args) {
		int tot = 0; // 누적합을 위한 변수
		for (int i = 1; i <= 10; i++) {
			if ((i % 2) != 0) {
				tot += i; // tot = tot + i;
			}
		}
		System.out.println("1부터10까지홀수 누적합은" + tot);
	}

}
