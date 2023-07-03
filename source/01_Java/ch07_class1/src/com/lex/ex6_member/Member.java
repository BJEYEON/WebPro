package com.lex.ex6_member;
/*데이터(속성) : id, pw, name, email, address, birth, gender
메소드 : “아이디 = aaa
         이름 = 홍길동
         이메일 = hong@company.com
         주소 = 서울 강남구
         생일 = 2000-01-01
         성별 = 남 ”(객체 정보)을 return하는 infoString() 메소드*/
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	public Member() {} //디폴트 생성자 함수
	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}

	public String infoPrint() {
		String str = (gender=='m' || gender=='M')? "남" : (gender=='f' ? "여":"-");
		String result = "ID: " + id;
		//result += "\nPW: " + pw;
		result += "\n이름: " + name;
		result += "\nemail: " + email;
		result += "\n주소: " + address;
		result += "\n생년월일: " + birth;
		result += "\n성별:" + str;
		return result;
	}
}
