package com.lec.ex2_access;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
		System.out.println(obj.defultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}

}
