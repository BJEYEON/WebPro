package com.lec.ex;

public class Student {
	private String str_studentNum;
	private String str_name;
	private int int_grade;
	private String str_class;
	private int int_score;
	public Student() {}
	public Student(String str_studentNum, String str_name, int int_grade, String str_class, int int_score) {
		super();
		this.str_studentNum = str_studentNum;
		this.str_name = str_name;
		this.int_grade = int_grade;
		this.str_class = str_class;
		this.int_score = int_score;
	}
	public String getStr_studentNum() {
		return str_studentNum;
	}
	public void setStr_studentNum(String str_studentNum) {
		this.str_studentNum = str_studentNum;
	}
	public String getStr_name() {
		return str_name;
	}
	public void setStr_name(String str_name) {
		this.str_name = str_name;
	}
	public int getInt_grade() {
		return int_grade;
	}
	public void setInt_grade(int int_grade) {
		this.int_grade = int_grade;
	}
	public String getStr_class() {
		return str_class;
	}
	public void setStr_class(String str_class) {
		this.str_class = str_class;
	}
	public int getInt_score() {
		return int_score;
	}
	public void setInt_score(int int_score) {
		this.int_score = int_score;
	}
	@Override
	public String toString() {
		return "Student [str_studentNum=" + str_studentNum + ", str_name=" + str_name + ", int_grade=" + int_grade
				+ ", str_class=" + str_class + ", int_score=" + int_score + "]";
	}
}
