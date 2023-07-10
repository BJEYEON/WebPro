package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;


public class StandardRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
		missile.missile();
	}
	@Override
	public void actionKnife() {
		knife.knife();

	}
	public FlyImpl getFly() {
		return fly;
	}
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}
	public MissileImpl getMissile() {
		return missile;
	}
	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}
	public KnifeImpl getKnife() {
		return knife;
	}
	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}

}
