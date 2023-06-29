package com.lec.loopQuiz;
//1부터10까지 누적곱
public class Quiz3 {
	public static void main(String[] args) {
		int tot = 1; // 누적곱을 위한 변수
		for (int i = 1; i <= 10; i++) {
			tot *= i; // tot = tot * i;

		}
		System.out.println("1부터10까지 누적곱은" + tot);
	}
}
