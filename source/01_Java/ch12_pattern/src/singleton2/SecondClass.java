package singleton2;

public class SecondClass {
	public SecondClass() {
		System.out.println("SecondClass ������ ������ --------------");
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i���� " + singletonObject.getI());
		System.out.println("SecondClass ������ ���� ��-------------");
	}

}
