package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

//actionWalk(), actionRun(), shape()
public class SuperRobot extends Robot {
//	private FlyImpl fly;
//	private MissileImpl missile;
//	private KnifeImpl knife;
	public SuperRobot() {
		
		setFly (new FlyYes()); //fly = new FlyYes();
		//fly = new FlyYes();
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
		//knife = new KnifeLazer();
	}
//	@Override
//	public void actionFly() {
//		fly.fly();
//	}
//	@Override
//	public void actionMissile() {
//		missile.missile();
//	}
//	@Override
//	public void actionKnife() {
//		knife.knife();
//	}
//	public FlyImpl getFly() {
//		return fly;
//	}
//	public void setFly(FlyImpl fly) {
//		this.fly = fly;
//	}
//	public MissileImpl getMissile() {
//		return missile;
//	}
//	public void setMissile(MissileImpl missile) {
//		this.missile = missile;
//	}
//	public KnifeImpl getKnife() {
//		return knife;
//	}
//	public void setKnife(KnifeImpl knife) {
//		this.knife = knife;
//	}
	

}
