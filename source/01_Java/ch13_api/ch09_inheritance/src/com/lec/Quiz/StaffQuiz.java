package com.lec.Quiz;

public class StaffQuiz extends PersonQuiz {
	private String staff;
	public static int count = 0;

	public StaffQuiz(String name, String id, String staff) {
		super(name, id);
		this.staff = staff;
		++count;
		setNo("staff" + count);
	}
	@Override
	public String infoString() {
		return super.infoString() + "\t(����)" + staff;
		
	}
	@Override
	public void print() {
		super.print();
			System.out.println("\t(����)" + staff);
		
	}

}
