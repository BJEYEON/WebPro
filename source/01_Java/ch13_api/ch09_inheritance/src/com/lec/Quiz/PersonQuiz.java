package com.lec.Quiz;

public class PersonQuiz {
	private String name;
	private String id;
	private String no;
//	private int serialNo;
//	public static int count = 0;
	public PersonQuiz(String name, String id) {
//		serialNo = ++count;
		this.name = name;
		this.id = id;
		this.no = no;
		
	}
	public String infoString() {
		return String.format("(번호)" + no +"(ID)" + id + "(이름)" + name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void print() {
		// TODO Auto-generated method stub
		
	}


}
