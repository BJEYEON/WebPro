package com.lec.ex08_customer;
// name, tel, infoString()
public class Staff extends Person {
	private String hiredate; //�Ի���("2020-12-01") �����ֺ��ʹ� Date��
	private String department; //�μ�
	//Staff s = new Staff("ȫ���", "9999-9999", "2023-01-01", "����")
	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}
	@Override
	public String infoString() {
		return super.infoString() + "[�Ի���]" + hiredate + "[�μ�]" + department;
	}
}
