package com.lec.ex3_exceptionEx;

import java.util.Date;

public class Ex02_FriendNullPointExceoption {
	public static void main(String[] args) {
		Friend hong  = new Friend("ȫ�浿", "010-9999-9999", new Date(98,11,12));
		System.out.println(hong);
		Friend kim = new Friend ("��浿", "010-8888-8888");
		System.out.println(kim);
	}

}
