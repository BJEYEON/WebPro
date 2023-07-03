package com.lex.ex6_member;

import com.lec.ex6_person.PersonInfo;

public class MemberMain {
	public static void main(String[] args) {
		Member member = new Member("aaa", "xxx", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", 'M');
		System.out.println(member.infoPrint());
		Member[] members = { new Member("aaa", "xxx", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", 'M'),
							 new Member("bbb", "xxx", "박제연", "jis12030@naver.com", "서울 은평구", "1998-10-21", 'M') };

		for (int idx = 0; idx < members.length; idx++) {
			System.out.println(members[idx].infoPrint());
			System.out.println("--------------");
		}
	}

}
