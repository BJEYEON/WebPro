package com.lec.Quiz;

public class TestMain {
	public static void main(String[] args) {
		PersonQuiz st1 = new StudentQuiz("A01","������","JAVA��");
		PersonQuiz st2 = new StudentQuiz("A02","ȫ�浿","C++��");
		PersonQuiz sf1 = new StaffQuiz("S01","���浿","�������");
		PersonQuiz sf2 = new StaffQuiz("S02","��浿","���������");
		PersonQuiz ga1 = new GangsaQuiz("G01","�̱浿","��ü����");
		PersonQuiz[] person = {st1, st2, sf1, sf2, ga1};
		for(PersonQuiz p : person) {
			//p.print();
			System.out.println(p.infoString());
		}
	}

}
