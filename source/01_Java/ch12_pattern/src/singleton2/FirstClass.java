package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 积己磊 角青吝");
		SingletonClass singletonObject = /*new SingletonClass();*/ SingletonClass.getInstance();
		System.out.println("教臂沛 按眉狼 i蔼:" + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("教臂沛 按眉狼i蔼 (荐沥饶):" + singletonObject.getI());
		System.out.println("FirstClass积己磊 角青场------------------------");
	}

}
