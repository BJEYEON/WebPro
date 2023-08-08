package com.lec.Quiz;

public class TestMain {
	public static void main(String[] args) {
		PersonQuiz st1 = new StudentQuiz("A01","강유미","JAVA반");
		PersonQuiz st2 = new StudentQuiz("A02","홍길동","C++반");
		PersonQuiz sf1 = new StaffQuiz("S01","유길동","운영지원팀");
		PersonQuiz sf2 = new StaffQuiz("S02","김길동","취업지원팀");
		PersonQuiz ga1 = new GangsaQuiz("G01","이길동","객체지향");
		PersonQuiz[] person = {st1, st2, sf1, sf2, ga1};
		for(PersonQuiz p : person) {
			//p.print();
			System.out.println(p.infoString());
		}
	}

}
