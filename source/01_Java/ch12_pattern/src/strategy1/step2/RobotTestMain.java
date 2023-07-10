package strategy1.step2;

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
			if (robot instanceof SuperRobot) {
				SuperRobot tempRobot = (SuperRobot)robot;
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionlnife();
			}
			else if (robot instanceof StandardRobot) {
				StandardRobot tempRobot = (StandardRobot)robot;
				tempRobot.actionFly();
				tempRobot.actionMissile();
				tempRobot.actionlnife();
			}
			else if(robot instanceof LowRobot) {
				LowRobot tempLowRobot = (LowRobot)robot;
				tempLowRobot.actionFly();
				tempLowRobot.actionMissile();
				tempLowRobot.actionlnife();
				
					
			}//if
			
		}//for
	}

}
