package com.lex.ex11_account;

public class TestMain {
	public static void main(String[] args) {
		Account acc1 = new Account("011-1", "ȫ�浿");
		CheclingAccount acc2 = new CheclingAccount("011-2", "��", 10000, "1234");
		CreditLineAccount acc3 = new CreditLineAccount("011-3", "��", 1000, "9876", 10000);
		acc1.deposite(10000);
		acc1.withdraw(9000);
		acc2.pay("1234", 11000);
		acc3.pay("1234", 11000);
	}

}
