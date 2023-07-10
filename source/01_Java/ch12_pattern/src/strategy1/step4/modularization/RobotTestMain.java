
package strategy1.step4.modularization;

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
	}

}
