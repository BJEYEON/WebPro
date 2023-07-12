package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex03_Date {
	public static void main(String[] args) {
		Date now = new Date();//지금시점
		//Date nowThat = new Date(2023-1900, 6, 12);비추
		Date nowThat = new Date(new GregorianCalendar(2023, 6, 1).getTimeInMillis());//특정시점
		System.out.println(now);
		
	}
	

}
