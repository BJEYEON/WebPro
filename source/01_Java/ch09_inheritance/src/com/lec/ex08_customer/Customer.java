package com.lec.ex08_customer;

import cons.Constant;

//name, tel/ infoString()
public class Customer extends Person{
	private String address;
	private int sum;//구매금액 누적
	private int point;//포인트(구매시 구매액의0.5%)
	private String date;//기념일(String을 다음주 부터는date형)
	private boolean vip;//일반고객(false) vip고객(true)
	//Customer c = new Customer("홍길동", "99999-999", "서울", "07-05")
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		point = 1000;
		this.date = date;
		System.out.println(name + "님 가입 감사합니다. 포인트1,0000점 넣어 드렸습니다");
		
	}
	public void buy(int price) {//c.buy(10000)
		//구매금액 누적
		sum += price;
		int thisPoint = (int)(price * Constant.RATE);// 이번 구매로 받은 포인트
		point += thisPoint;
		//포인트Consant.Rate%누적
		//감사문구 출력
		System.out.println(getName() + "님 구매 감사. 금범 구매 포인트는 " + thisPoint);
		System.out.println("총 누적 포인트는" + point);
		System.out.println("구매금액:" + price);
		//vip고객이 아닐경우 Constant.VIPLIMIT이상 구매 누적금액일 경우 vip=true
		if (vip == false&& sum>=Constant.VIPLIMIT) {
			vip = true;
			System.out.println("vip고객으로 업그레이드 되셨습니다. 자주뵙겠습니다");
		}//if
	}//buy
	@Override
	public String infoString() {
		return super.infoString() + "[주소]" + address + "[포인트]" + point  + "[구매누적]" + sum + "[vip여부]" + (vip==true?"vip":"일반");
	}
}
