package com.lec.ex06_bool;

public interface ILendable {
	public byte STATE_BORROWED = 1; //대출중을 의미
	public byte STATE_NORMAL = 0;//대출가능을 의미
	public void checkOut(String borrower, String checkoutDate); //대출 
	public void checkIn(); //반납
	public void printState(); // 책번호 책이름(저자) 대출가능여부 출력
}
