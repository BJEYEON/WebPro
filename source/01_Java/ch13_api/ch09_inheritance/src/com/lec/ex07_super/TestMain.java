package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("¾Æºü°õ"); papa.setCharacter("¶×¶×ÇØ");
		papa.intro();
		Person mom = new Person("¾ö¸¶°õ", "³¯¾ÀÇØ");
		mom.intro();
		Person child = new Baby();
		child.setName("¾Æ±â°õ1"); child.setCharacter("±Í¿©¿ö");
		child.intro();
		Baby child2 = new Baby("¾Æ±â°õ2", "³Ê¹« ±Í¿©¿ö");
		child2.intro();
		
	}
}
