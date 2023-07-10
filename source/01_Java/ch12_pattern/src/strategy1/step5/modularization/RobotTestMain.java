
package strategy1.step5.modularization;

import strategy1.step4.modularization.FlyHigh;
import strategy1.step4.modularization.ToyKnife;

public class RobotTestMain {
	public static void main(String[] args) {
		Robot superRobot = new SuperRobot();
		Robot standRobot = new StandardRobot();
		Robot lowRobot = new LowRobot();
		Robot[] robots = {superRobot, standRobot, lowRobot};
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			
		}//for
		System.out.println("SuperRobot높아 아주 높이 날수 있는 기능으로 업그레이드");
		superRobot.setFly(new FlyHigh());
		superRobot.shape();
		superRobot.actionFly();
		System.out.println("LowRobot의 장난감 검이 있는 기능으로 업그레이드");
		lowRobot.setKnife(new ToyKnife());
		lowRobot.shape();
		lowRobot.actionKnife();
	}

}
