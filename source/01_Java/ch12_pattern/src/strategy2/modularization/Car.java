package strategy2.modularization;
//�Ӽ�����-������-�޼ҵ�(�Ϲݸ޼ҵ�-�������̵��� �޼ҵ�-setter&getter

import strategy2.interfaces.EngineImpl;
import strategy2.interfaces.FuellImpl;
import strategy2.interfaces.KmImpl;

public abstract class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuellImpl fuel;
	public void drive() {
		System.out.println("����̺� �� ���ֽ��ϴ�.");
	}
	public abstract void shape();
	public void isEngine() {
		engine.engine();
	}
	public void isKmerLiter() {
		km.kmPerLiter();
	}
	public void isFuel() {
		fuel.fuel();
	}
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setKm(KmImpl km) {
		this.km = km;
	}
	public void setFuel(FuellImpl fuel) {
		this.fuel = fuel;
	}
	
	
	

}
