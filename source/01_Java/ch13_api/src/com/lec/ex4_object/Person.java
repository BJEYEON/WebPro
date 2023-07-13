package com.lec.ex4_object;
//데이터 (private) + 생성자 + 메소드(기능, setter&getter, 오버라이드할 메소드)
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
		return "주민번호는" + juminno;
	}
	@Override
	public boolean equals(Object obj) {
		//p1.equals(p2)
		//(this.)juminNO와 obj.juminNo같으면true를 return
		if (obj!=null && obj instanceof Person) {//obj는모든객체 가능 person main에있는 new옆에있는 변수가person인지?
			Person other = (Person)obj;
			boolean juminNoChk = (juminno == other.juminno);
			return juminNoChk;
		}
		return false;
	}
}
