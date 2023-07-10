package strategy2.modularization;

import strategy2.interfaces.EngineMid;
import strategy2.interfaces.FuelHybrid;
import strategy2.interfaces.km20;

public class SonataHybrid extends Car {
	public SonataHybrid() {
		setEngine(new EngineMid());
		setKm(new km20());
		setFuel(new FuelHybrid());
			
	}
	@Override
	public void shape() {
		System.out.println("쏘나타 차량은 문, 시트, 핸들로 이루어져 있습니다.");
	}

}
