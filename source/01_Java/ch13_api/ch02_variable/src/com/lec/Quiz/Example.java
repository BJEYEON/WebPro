package com.lec.Quiz;

public class Example {
	public static void main(String[] args) {
		int kor = 90;
		int eng = 80;
		int math = 70;
		int total;
		total = kor + eng + math; //총점
		System.out.println("수학점수: " + math + "점");
		System.out.println("영어점수: " + eng + "점");
		System.out.println("국어점수: " + kor + "점");
		System.out.println("평군점수: " + (double)total/3 + "점");
		
		System.out.print("수학점수: " + math + "점");
		System.out.print("영어점수: " + eng + "점");
		System.out.print("국어점수: " + kor + "점");
		System.out.print("평군점수: " + (double)total/3 + "점");
		
		System.out.print("수학점수: " + math + "점");
		System.out.print("영어점수: " + eng + "점");
		System.out.print("국어점수: " + kor + "점");
		System.out.print("평군점수: " + (double)total/3 + "점");
		
		System.out.printf("\r\n수학점수=%d", math);
		System.out.printf("\r\n영어점수=%d", eng);
		System.out.printf("\r\n국어점수=%d", kor);
		System.out.printf("\r\n평군점수=%f", total/3.0);
	}

}
