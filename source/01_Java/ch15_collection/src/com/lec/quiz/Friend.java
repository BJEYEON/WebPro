package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private String address;
	private Date birth;
	
	public Friend(String name, String address, String tel, Date birth) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.birth = birth;
	}
	@Override
	public String toString() {
		SimpleDateFormat asd = new SimpleDateFormat("MM-dd");
		return "이름:" + name + "\n주소:" + address + "\n전화번호:" + tel + "\n생일:" + asd.format(birth);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
