package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass ������ ������");
		SingletonClass singletonObject = /*new SingletonClass();*/ SingletonClass.getInstance();
		System.out.println("�̱��� ��ü�� i��:" + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("�̱��� ��ü��i�� (������):" + singletonObject.getI());
		System.out.println("FirstClass������ ���ೡ------------------------");
	}

}
