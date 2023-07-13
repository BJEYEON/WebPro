package com.lec.ex4_object;
//데이터 - 생성자- 메소드(일반메소드-setter&getter오버라이드
//new("♥",3)
public class Card {
	private String kind;
	private int num;
	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "카드:" + kind + "-" + num;
	}
	@Override
	public boolean equals(Object obj) {
		//c1.equal(c2) ->c1은 this, c2는obj
		//this.kinf와 obj.kind가 같은지 -> kindchk(true/false)
		//(this.)num와obj.num이 같은 chk -> numchk(true/false)
		//return kindchk && numchk
		if (obj!=null && obj instanceof Card) {
			Card other = (Card)obj;//형변환
			boolean cardChk = (kind.equals(other.kind));
			boolean cardChk2 = (num == other.num);
			return cardChk&&cardChk2;
			
		}
		return false;
	}
}
