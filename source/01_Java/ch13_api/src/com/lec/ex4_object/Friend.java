package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
// new Friend ("ȫ", "010-9999-9999", "����� ���빮��", new Date(98,11,12))
//new Friend ("ȫ", "010-9999-9999", "����� ���빮��", new Date(new GregorianCalendar(1998,11,12).grtTime~))

public class Friend {
	private String name;
	private String tel;
	private String address;
	private Date birthday;
	public Friend(String name, String tel, String address, Date birthday) {
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "�̸�:" + name + "\n�ּ�:" + address + "\n�ڵ���:" + tel + "\n����:" + sdf.format(birthday) + "\n";
	}
	//getter
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public Date getBirthday() {
		return birthday;
	}
}
