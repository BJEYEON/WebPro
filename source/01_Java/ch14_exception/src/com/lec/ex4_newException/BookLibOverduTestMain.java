package com.lec.ex4_newException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

//책객체 -> 대출 -> 대출일3주전으로setting -> 반납
public class BookLibOverduTestMain {
	public static void main(String[] args) {
		Book book = new Book("950-ㄱ10", "이것이 자바다", "신윤권");
		System.out.println("대출전:" + book);
		book.checkOut("홍길동");//대출
		//book.setCheckOutDate(new Date(2023-1900, 5, 23));대출일을 3주전으로 강제setting
		book.setCheckOutDate(new Date(new GregorianCalendar(2023,5,23).getTimeInMillis()));
		//SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println("대출후: " + book);
		try {
			book.checkIn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("반납처리 확인" + book);
	}

}
