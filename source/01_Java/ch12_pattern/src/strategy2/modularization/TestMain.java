package strategy2.modularization;

import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.km20;


public class TestMain {
	public static void main(String[] args) {
//		Car[] cars = {new Accent(), new Genesis(), new Sonata() };
//		for (int idx=0; idx<cars.length; idx++) {
//			cars[idx].shape();
//			cars[idx].drive();
//			cars[idx].isEngine();
//			cars[idx].isKmerLiter();
//			cars[idx].isFuel();
//		}
		System.out.println("쏘나타의 연료는 hybrid로, 연비를 20km/l로 업그레이드");
		Car[] cars = {new Accent(), new Genesis(), new Sonata()};
		cars[2].setFuel(new FuelHybrid());
		cars[2].setKm(new km20());
		
		for (int idx=0; idx<cars.length; idx++) {
			cars[idx].shape();
			cars[idx].drive();
			cars[idx].isEngine();
			cars[idx].isKmerLiter();
			cars[idx].isFuel();
		}
	}

}
