package com.lec.ex4_object;

import java.util.Random;

public class Ex3_CardMain {
	public static void main(String[] args) {
		
//		Card c1 = new Card("♥", 3);
//		Card c2 = new Card("♥", 3);
//		Card c3 = null;
//		System.out.println(c1);
//		System.out.println(c2);
//		System.out.println("c1과c2가 같은주쇼냐?" + (c1==c2));
////		int i = 10, j=10;
////		System.out.println("i과j가 같냐?" + (i==j));
//		System.out.println("c1과c2가 같은 카드냐?" + c1.equals(c2));
		
		
		
		Card[] cards = { new Card("♥",3 ),new Card("♠",3 ),
				         new Card("♥",5 ),new Card("♠",4 ),
				         new Card("♥",7 ),new Card("♠",5 ),
				         new Card("♥",8 ),new Card("♠",6 ),
				         new Card("♥",9 ),new Card("♠",7 ),};
				         //임의의 뽑힌카드와 배열안의 카드를 비교해서 일치하는 카드가 나오면 출력, 일치하는 카드가 없으면 땡 출력
						Random random = new Random();
						String[] kinds = {"♥","♠", "◆" , "♣"};
						int idx = random.nextInt(4);//0~4난수
						Card randomCard = new Card(kinds[idx], random.nextInt(13)+1);
						System.out.println("컴퓨터의 선택은" + randomCard);
						int i;
						for (i=0; i<cards.length; i++) {
							if (randomCard.equals(cards[i])) {
								System.out.println(i + "번째 카드와 일치합니다." + cards[i]);
								break;
							}
						}
						if(i == cards.length) {
							System.out.println("땡");
						}
	}

}
