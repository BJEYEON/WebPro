package com.lec.ex04_actor;

public class ActorTestMain {
	public static void main(String[] args) {
		Actor tom = new Actor("톰 크루즈");
		tom.outFire();
		tom.saveMan();
		tom.canCatchCriminal();
		tom.canSearch();
		tom.makePizza();
		tom.makeSpaghetti();
		System.out.println("----------------------------");
		IFireFighter fireTom = tom;
		fireTom.outFire();
		fireTom.saveMan();
		//fireTom.make스파게티
		Ichef chefTom = tom;
		chefTom.makePizza();
		chefTom.makeSpaghetti();
		IPoliceMan policeTom = tom;
		policeTom.canCatchCriminal();
		policeTom.canSearch();
		
	}

}
