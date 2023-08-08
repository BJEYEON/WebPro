package com.lex.ex11_account;
//accountNo, ownerName, balace, cardNO, deposit, withdraw, infoPrint, infoString,pay
public class CreditLineAccount extends CheclingAccount {
	private int creditLine;// ī���ѵ�
	public CreditLineAccount(String accountNo, String ownerName, String carNo, int creditLine) {
		super(accountNo, ownerName, carNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, int balance, String carNo, int creditLine) {
		super(accountNo, ownerName, balance, carNo);
		this.creditLine = creditLine;
	}
	//ca1.pay("1231231231234", 10000)
	@Override
		public void pay(String carNo, int amount) {
			if (carNo.equals(getCarNo())) {//�ùٸ� ī���ȣ�� ���
				if (creditLine >= amount) {//���Ұ���
					creditLine -= amount;// �ܾ��� amount��ŭ ����
					System.out.printf("%s��%�� �����Ͽ� �ѵ� %�� ���ҽ��ϴ�\n", getOwnerName(), amount,creditLine);
				}
				else {//�ܾ� ����
					System.out.println(getOwnerName() + "�� �ѵ� �������� ���� �Ұ��մϴ�");
				}
			}
			else {
				System.out.println("��ȿ�� ī���ȣ�� �ƴմϴ�.");
			}
		}
	private void creditLine(int i) {
		// TODO Auto-generated method stub
		
	}
}
