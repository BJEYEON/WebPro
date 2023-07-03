package com.lex.ex6_member;
/*������(�Ӽ�) : id, pw, name, email, address, birth, gender
�޼ҵ� : �����̵� = aaa
         �̸� = ȫ�浿
         �̸��� = hong@company.com
         �ּ� = ���� ������
         ���� = 2000-01-01
         ���� = �� ��(��ü ����)�� return�ϴ� infoString() �޼ҵ�*/
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	public Member() {} //����Ʈ ������ �Լ�
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
		String str = (gender=='m' || gender=='M')? "��" : (gender=='f' ? "��":"-");
		String result = "ID: " + id;
		//result += "\nPW: " + pw;
		result += "\n�̸�: " + name;
		result += "\nemail: " + email;
		result += "\n�ּ�: " + address;
		result += "\n�������: " + birth;
		result += "\n����:" + str;
		return result;
	}
}
