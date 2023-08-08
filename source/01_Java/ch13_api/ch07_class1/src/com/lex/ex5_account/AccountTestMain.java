package com.lex.ex5_account;


public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("011-1234", "È«±æµ¿", 10000);
		System.out.println(hong.infoString());
		Account hong1 = new Account("012-9875", "È«±æÀÚ");
		hong1.infoPrint();
		hong.withdraw(5000);
		hong.withdraw(10);
		hong.deposite(100000);
	}
	
// getter(account
}
