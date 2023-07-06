package com.lec.ex10_final;

public class Main {
	public static void main(String[] args) {
		Animal[] animals = {new Animal(),
							new Dog(), 
							new BlueDog(), 
							new Rabbit()};
		for (Animal animal : animals) {
			animal.running();
			animal.running();
			animal.stop();
			System.out.println("===============================");
		}//for
	}
}
