package com.lec.ex4_object;

import java.util.Random;

public class Ex3_CardMain {
	public static void main(String[] args) {
		
//		Card c1 = new Card("��", 3);
//		Card c2 = new Card("��", 3);
//		Card c3 = null;
//		System.out.println(c1);
//		System.out.println(c2);
//		System.out.println("c1��c2�� �����ּ��?" + (c1==c2));
////		int i = 10, j=10;
////		System.out.println("i��j�� ����?" + (i==j));
//		System.out.println("c1��c2�� ���� ī���?" + c1.equals(c2));
		
		
		
		Card[] cards = { new Card("��",3 ),new Card("��",3 ),
				         new Card("��",5 ),new Card("��",4 ),
				         new Card("��",7 ),new Card("��",5 ),
				         new Card("��",8 ),new Card("��",6 ),
				         new Card("��",9 ),new Card("��",7 ),};
				         //������ ����ī��� �迭���� ī�带 ���ؼ� ��ġ�ϴ� ī�尡 ������ ���, ��ġ�ϴ� ī�尡 ������ �� ���
						Random random = new Random();
						String[] kinds = {"��","��", "��" , "��"};
						int idx = random.nextInt(4);//0~4����
						Card randomCard = new Card(kinds[idx], random.nextInt(13)+1);
						System.out.println("��ǻ���� ������" + randomCard);
						int i;
						for (i=0; i<cards.length; i++) {
							if (randomCard.equals(cards[i])) {
								System.out.println(i + "��° ī��� ��ġ�մϴ�." + cards[i]);
								break;
							}
						}
						if(i == cards.length) {
							System.out.println("��");
						}
	}

}
