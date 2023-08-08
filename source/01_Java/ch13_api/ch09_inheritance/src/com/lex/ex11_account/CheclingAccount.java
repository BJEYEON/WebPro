package com.lex.ex11_account;
//account, ownerName, deposit, dithdraw, infiPrint infoSring
//keckingAccount ca1 = 
//CheckingAccount cal = new CkeckingAccount(“111-1111”,”김길
//동”,[1000,] ”1234-1234-1234-1234”);
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
		if (carNo.equals(this.carNo)) {//올바른 카드번호인 경우
			if (getBalance() >= amount) {//지불가능
				setBalance( getBalance() - amount);// 잔액을 amount만큼 차감
				System.out.printf("%s님%원 지불하여 %s 계좌에 잔액 %d입니다\n", getOwnerName(), amount, getAccountNo(), getBalance());
			}
			else {//잔액 부족
				System.out.println(getOwnerName() + "님 잔액 부족으로 지불 불가합니다");
			}
		}
		else {
			System.out.println("유효한 카드번호가 아닙니다.");
		}
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	


}
