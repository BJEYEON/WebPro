package com.lex.ex11_account;
//account, ownerName, deposit, dithdraw, infiPrint infoSring
//keckingAccount ca1 = 
//CheckingAccount cal = new CkeckingAccount(��111-1111��,�����
//����,[1000,] ��1234-1234-1234-1234��);
public class CheclingAccount extends Account {
	private String carNo;
	public CheclingAccount(String accountNo, String ownerName, String carNo) {
		super(accountNo, ownerName);
		this.carNo = carNo;
		
	}
	public CheclingAccount(String accountNo, String ownerName, int balance, String carNo) {
		super(accountNo, ownerName, balance);
		this.carNo = carNo;
		
	}
	//ca1.pay("1231231231234", 10000)
	public void pay(String carNo, int amount) {
		if (carNo.equals(this.carNo)) {//�ùٸ� ī���ȣ�� ���
			if (getBalance() >= amount) {//���Ұ���
				setBalance( getBalance() - amount);// �ܾ��� amount��ŭ ����
				System.out.printf("%s��%�� �����Ͽ� %s ���¿� �ܾ� %d�Դϴ�\n", getOwnerName(), amount, getAccountNo(), getBalance());
			}
			else {//�ܾ� ����
				System.out.println(getOwnerName() + "�� �ܾ� �������� ���� �Ұ��մϴ�");
			}
		}
		else {
			System.out.println("��ȿ�� ī���ȣ�� �ƴմϴ�.");
		}
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	


}
