package com.lec.ex4_object;
//������ (private) + ������ + �޼ҵ�(���, setter&getter, �������̵��� �޼ҵ�)
//Person p1 = new Person();
//Person p2 = new Person(9810211173721);
public class Person {
	private long juminno; //9810211173721
	public Person() {}
	public Person(long juminno) {
		this.juminno = juminno;
	}
	@Override
	public String toString() {
		return "�ֹι�ȣ��" + juminno;
	}
	@Override
	public boolean equals(Object obj) {
		//p1.equals(p2)
		//(this.)juminNO�� obj.juminNo������true�� return
		if (obj!=null && obj instanceof Person) {//obj�¸�簴ü ���� person main���ִ� new�����ִ� ������person����?
			Person other = (Person)obj;
			boolean juminNoChk = (juminno == other.juminno);
			return juminNoChk;
		}
		return false;
	}
}
