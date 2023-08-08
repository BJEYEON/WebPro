package com.lec.ex;
//논리연산자 : &&(and) ||(or), !
public class Ex04 {
	public static void main(String[] args) {
		int i = 1, j = 10, h = 10;
		System.out.println("&&(AND) : (i<j) && (++j>h)는" + ( (i<j) && (++j>h) ));
		System.out.println("j = " + j);
		//&&연산자의 경우 좌항이 false인경우 우항의 값은 보지도 않고 결과를 false로
		System.out.println("&&(AND) : (i<j) && (++j>h)는" + ( (i>j) && (++j>h) ));
		System.out.println("j = " + j);
		// ||연산자의 경우 좌항이 true이면 우항은 값을 보지도 않고 결과를 true
		System.out.println("||(or) : (i<j) && (++j>h)는" + ( (i<j) || (++j>h) ));
		System.out.println("j = " + j);
		
		System.out.println("||(or) : (i<j) && (++j>h)는" + ( (i>j) || (++j>h) ));
		System.out.println("j = " + j);
	}

}
