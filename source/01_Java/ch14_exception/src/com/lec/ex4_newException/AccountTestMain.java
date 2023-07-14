package com.lec.ex4_newException;


public class AccountTestMain {
	public static void main(String[] args) {
		Account hong = new Account("011-1234", "È«±æµ¿", 10000);
		System.out.println(hong);
		Account hong1 = new Account("012-9875", "È«±æÀÚ");
		System.out.println(hong1);
		try {
			hong.withdraw(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			hong1.withdraw(10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		hong1.deposite(100000);
	}
	
// getter(account
}
