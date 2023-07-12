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
	SimpleDateFormat form = new SimpleDateFormat("yyyy년MM월dd일");
	public String infoPrint() {
		
		String result = "[사번] " + sawonNum;
		result += "\t [이름]: " + name;
		result += "\t [부서]" + depart;
		result += "\t [입사일]: " + form.format(date);
		return result;
	}
	@Override
	public String toString() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		return "[사번]" + sawonNum + "\t[이름]" + name + "\t[부서]" + depart + "\t[입사일]" + form.format(date);
	}

}
