package strategy2.modularization;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.km10;

public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new km10());
		setFuel(new FuelGasoline());
			
	}
	@Override
	public void shape() {
		System.out.println("���׽ý� ������ ��, ��Ʈ, �ڵ�� �̷���� �ֽ��ϴ�.");
	}

}
