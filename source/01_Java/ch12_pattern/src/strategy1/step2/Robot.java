package strategy1.step2;

public class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ִ�");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void shape() {//"xxRobot�� ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�"���
		String className = getClass().getName(); //"strategy1.step2.SuperRobot"
		int idx = className.lastIndexOf("."); //�Ǹ������� ������".�� "��ġ 15
		String name = className.substring(idx+1);
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
		
	}

}
