package com.lec.ex2_date;

import java.util.Date;
import java.util.GregorianCalendar;

//�ν��� ���� ���
public class Ex04_term {
	public static void main(String[] args) {
		Date now1 = new Date(); //����
		Date now2 = new Date(new GregorianCalendar(2023, 5, 26, 9, 30, 0).getTimeInMillis());//Ư����¥
		long now1Millis = now1.getTime();//1970.1.1~ now1������ �и�����
		long now2Millis = now2.getTime();//1970.1.1~ now2������ �и�����
		long day = (now1Millis - now2Millis)/(1000*60*60*24);
		System.out.println("���� ��������:" + day);
	}

}
