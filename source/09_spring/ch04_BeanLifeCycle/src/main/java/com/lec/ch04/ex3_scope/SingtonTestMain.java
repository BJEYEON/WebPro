package com.lec.ch04.ex3_scope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingtonTestMain {
	public static void main(String[] args) {
		String loc = "classpath:META-INF/ex3/CTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(loc);
		Friend friend1 = ctx.getBean("friend", Friend.class);
		Friend friend2 = ctx.getBean("friend", Friend.class);
		System.out.println("friend1:" + friend1);
		System.out.println("friend2:" + friend2);
		friend1.setFriendNo(9);
		friend1.setName("박길숙");
		friend1.setTel("000-0000-0000");
		System.out.println("friend1:" + friend1);
		System.out.println("friend2:" + friend2);
		System.out.println("-------위는 싱글톤 아래의 빈은 싱글톤 아니게getBean------");
		Friend f1 = ctx.getBean("friendProto", Friend.class);
		Friend f2 = ctx.getBean("friendProto", Friend.class);
		f1.setFriendNo(999);
		f1.setName("구구구");
		f1.setTel("999");
		System.out.println("f1" + f1);
		System.out.println("f2" + f2);
		ctx.close();
	}
}
