package com.lec.ex2;

import com.lec.ex2_access.AccessTest;

public class AccessTestMain {
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
//		System.out.println(obj.defultMember);
//		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
//		obj.defaultMethod();
//		obj.protectedMethod();
//		obj.publicMethod();
		obj.publicMethod();
	}

}
