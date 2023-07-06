package com.lec.Quiz;

public class StudentQuiz extends PersonQuiz {
	private String ban;
	private int serialNo;
	public static int count = 0;
	
	public StudentQuiz(String name, String id, String ban) {
		super(name, id);
		this.ban = ban;
		++count;
		setNo("student" + count);
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(¹Ý)" + ban;
		
	}
	@Override
	public void print() {
		super.print();
			System.out.println("\t(¹Ý)" + ban);
		
	}

	
}
