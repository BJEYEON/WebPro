package com.lec.Quiz;

public class GangsaQuiz extends PersonQuiz {
	private String buseo;
	public static int count = 0;
	public GangsaQuiz(String name, String id, String buseo) {
		super(name, id);
		this.buseo = buseo;
		++count;
		setNo("lecturer" + count);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(부서)" + buseo;
		
	}
	@Override
	public void print() {
		super.print();
			System.out.println("\t(부서)" + buseo);
		
	}

}
