package strategy2.modularization;

import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.km15;

public class Sonata extends Car {
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new km15());
		setFuel(new FuelGasoline());
			
	}
	@Override
	public void shape() {
		System.out.println("쏘나타 차량은 문, 시트, 핸들로 이루어져 있습니다.");
	}

}
