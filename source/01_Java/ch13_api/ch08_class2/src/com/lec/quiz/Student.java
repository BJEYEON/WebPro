package com.lec.quiz;
// 데이터(이름, 국영수 총평) 생성자 함수 메소드, setter&getter
//Student s = new Student("정우성", 100,99,99);
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int avg;
	private int serialNo;
	public static int count = 0;
	public Student() {
	}
	//public Student() {} //디폴트 생성자
	public Student(String name, int kor, int eng, int mat) {
		serialNo = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot/3;
	}
	public void print() {
		//System.out.printf("\t%s \t %d \t %d \t %d \t %d \t %.2f\n", name, kor, eng, mat, tot, avg);
	}
	public String infoString() {
		//return "\t" + name + ""\t등등
		return String.format("%d  %s \t %d \t %d \t %d \t %d \t %d",serialNo, name, kor, eng, mat, tot, avg );
	}
	//getter
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
	public Student(int serialNo) {
		this.serialNo = serialNo;
	}
	public void infoPrint() {
		
	}
}
