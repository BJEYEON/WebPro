package com.lec.ex4_object;
//������ - ������- �޼ҵ�(�Ϲݸ޼ҵ�-setter&getter�������̵�
//new("��",3)
public class Card {
	private String kind;
	private int num;
	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "ī��:" + kind + "-" + num;
	}
	@Override
	public boolean equals(Object obj) {
		//c1.equal(c2) ->c1�� this, c2��obj
		//this.kinf�� obj.kind�� ������ -> kindchk(true/false)
		//(this.)num��obj.num�� ���� chk -> numchk(true/false)
		//return kindchk && numchk
		if (obj!=null && obj instanceof Card) {
			Card other = (Card)obj;//����ȯ
			boolean cardChk = (kind.equals(other.kind));
			boolean cardChk2 = (num == other.num);
			return cardChk&&cardChk2;
			
		}
		return false;
	}
}
