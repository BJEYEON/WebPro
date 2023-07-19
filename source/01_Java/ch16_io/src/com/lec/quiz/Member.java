package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private Date birth;
	private String address;

	public Member(String name, String tel, Date birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}

	@Override
	public String toString() {
		if (birth!=null) {
			SimpleDateFormat asd = new SimpleDateFormat("MM-dd");
			return name + "\t" + tel + "\t" + asd.format(birth) + "\t" + address;
		}
		
		return name + "\t" + tel + "\t" + "생일모름" + "\t" + address;
	}

}
