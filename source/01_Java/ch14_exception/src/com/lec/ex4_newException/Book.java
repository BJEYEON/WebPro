package com.lec.ex4_newException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Book book = new Book("890-a01", "Java", "신윤권")
public class Book implements ILendable {
	private String bookNo; // 청구번호
	private String bookTitle;// 책이름
	private String writer;// 저자
	private String borrower;// 대출인
	private Date checkOutDate;// 대출일07-08
	private byte state;// 대출가능(0), 대출중(1)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {// 대출
		if (state == STATE_BORROWED) { // 대출중인 상태이면 메세지 뿌리고메소드끝
			System.out.println(bookTitle + "도서는 대출중입니다");
			return;
		}
		// state 0(대출가능) 이라서 대출진행
		this.borrower = borrower;
		checkOutDate = new Date();// 대출일은 현재로
		state = STATE_BORROWED;// 대출중으로상태전환
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(bookTitle + "도서가 대출되었습니다");
		System.out.println("대출인: " + borrower + "\t대출일: " + sdf.format(checkOutDate));

	}

	@Override
	public void checkIn() throws Exception {// 반납
		if (state == STATE_NORMAL) {// 대출가능한 책이면 메세지 뿌리고 메소드 끝
			// 강제로 예외 발생
			throw new Exception(bookTitle + "도서는 반납이 완료된 책입니다. 확인하세요");
		}
		// 현재 날짜를 시스템으로부터 가져와서 대출일 (checkOutDate)과 현재의 날짜차이를 계산 -> 14일 지났으면 연체
		// state가 대출중(1)이라 반납처리
		// checkOutDate~지금까지의 날짜계산
		Date now = new Date();
		long checkOutDateMilli = checkOutDate.getTime();//1970.1.1~대출일까지의 밀리세컨
		long nowMilli = now.getTime();//1970.1.1~now까지의 밀리세컨
		long diff = nowMilli - checkOutDateMilli;//대출일~now까지의 밀리세컨
		int day = (int)diff/ (1000*60*60*24);//대출일~now까지의 날짜 수
		if (day>14) {//연체
			day -= 14;//연체일
			System.out.println(day + "일 만큼 연체되어" + (day*100) + "연체료 부과 됩니다. 연체료 받으셨나요(Y/N)?");
			Scanner scanner = new Scanner(System.in);
			if (!scanner.next().trim().equalsIgnoreCase("y")) {
				System.out.println("연체료 미납하시면 반납처리 안댑니다.");
				return;
				
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다.");

	}

	@Override
	public String toString() {
		String msg = bookNo + "\t" + bookTitle + "(" + writer + "저)";
		msg += state == STATE_BORROWED ? "대출중(대출일:)" + checkOutDate  + ")" : "대출가능";
		return msg;
	}

//getter
	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public String getBorrower() {
		return borrower;
	}


	public byte getState() {
		return state;
	}
	//setter:대출일 조작(연체 테스트)

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public void printState() {
		// TODO Auto-generated method stub
		
	}
	

}
