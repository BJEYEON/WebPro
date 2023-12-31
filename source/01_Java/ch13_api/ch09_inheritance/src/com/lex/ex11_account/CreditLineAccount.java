package com.lex.ex11_account;
//accountNo, ownerName, balace, cardNO, deposit, withdraw, infoPrint, infoString,pay
public class CreditLineAccount extends CheclingAccount {
	private int creditLine;// 카드한도
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
			if (carNo.equals(getCarNo())) {//올바른 카드번호인 경우
				if (creditLine >= amount) {//지불가능
					creditLine -= amount;// 잔액을 amount만큼 차감
					System.out.printf("%s님%원 지불하여 한도 %원 남았습니다\n", getOwnerName(), amount,creditLine);
				}
				else {//잔액 부족
					System.out.println(getOwnerName() + "님 한도 부족으로 지불 불가합니다");
				}
			}
			else {
				System.out.println("유효한 카드번호가 아닙니다.");
			}
		}
	private void creditLine(int i) {
		// TODO Auto-generated method stub
		
	}
}
