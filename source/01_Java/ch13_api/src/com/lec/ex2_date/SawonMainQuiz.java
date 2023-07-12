package com.lec.ex2_date;

public class SawonMainQuiz {
	public static void main(String[] args) {

		SawonQuiz[] sawons = { new SawonQuiz("a01", "È«±æµ¿", "COMPUTER"),
				               new SawonQuiz("a02", "±è±æµ¿", "DESIGN", 2023, 07, 11) };
		for (int i = 0; i < sawons.length; i++) {
			System.out.println(sawons[i].toString());
			
		}
		
	}

}
