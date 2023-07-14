package com.lec.ex4_newException;

/*  �������(Account) Ŭ���� ���� new Account("110-98", "ȫ�浿") Account("110-99", "�̸�", 100)
������(�Ӽ�) : ���¹�ȣ, ������, �ܾ�
���(�޼ҵ�) : �����ϴ�. �����ϴ�  �������� ���. ���������� ���ڿ��� return*/
public class Account {
	private String accountNo; // ���¹�ȣ
	private String ownerName; // ������
	private int balance; // �ܾ�

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "�� ���°��� �����մϴ�. �ܾ�: 0");
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName + "�� ���°��� �������� �����մϴ�. �ܾ�: " + balance);
	}

	public void deposite(int money) {// �����ǿ���
		balance += money;// balance = balance+money;
		System.out.println(accountNo + ":" + money + "�� �����Ͽ� �ܾ�:" + balance);
	}

	public void withdraw(int money) throws Exception { // �ܾ��� ������츸 ����. �ܾ׺����� ���� ���
		if (balance >= money) {
			balance -= money;
			System.out.println(accountNo + ":" + money +"�� �����Ͽ� �ܾ� : " + balance);
		} else {
			//System.out.println("�ܾ��� �����Ͽ� ���� �Ұ� �մϴ�");
			throw new Exception(ownerName + "�ܾ��� �����Ͽ� ������� �ʾҽ��ϴ�.");
			
		}
	}
	public void infoPrint() {// "101-1234" ȫ�浿�� �ܾ� :100�� �� ���
		//System.out.println("\"" + accountNo + "\" " + ownerName + "�� �ܾ�:" + balance + "��");
		System.out.printf("\"%s \" %s�� �ܾ�: %d��\n", accountNo, ownerName, balance);
	}
@Override
	public String toString() {// "101-1234" ȫ�浿�� �ܾ�: 1000�� �� return
		return String.format("\"%s \" %s�� �ܾ�: %d��\n", accountNo, ownerName, balance);
	}
//getter&setter
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
