package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class SawonQuiz {
	
	private String sawonNum;
	private String name;
	private String depart;
	private Date date;
	private int yyyy;
	private int MM;
	private int dd;
	
	public SawonQuiz(String sawonNum, String name, String depart) {
		this.sawonNum = sawonNum;
		this.name = name;
		this.depart = depart;
	
		date = new Date();
	}
	public SawonQuiz(String sawonNum, String name, String depart, int yyyy, int MM, int dd) {
		this.sawonNum = sawonNum;
		this.name = name;
		this.depart = depart;
		MM = MM-1;
		date = new Date(new GregorianCalendar(yyyy, MM, dd).getTimeInMillis());
	}
	SimpleDateFormat form = new SimpleDateFormat("yyyy��MM��dd��");
	public String infoPrint() {
		
		String result = "[���] " + sawonNum;
		result += "\t [�̸�]: " + name;
		result += "\t [�μ�]" + depart;
		result += "\t [�Ի���]: " + form.format(date);
		return result;
	}
	@Override
	public String toString() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		return "[���]" + sawonNum + "\t[�̸�]" + name + "\t[�μ�]" + depart + "\t[�Ի���]" + form.format(date);
	}

}
