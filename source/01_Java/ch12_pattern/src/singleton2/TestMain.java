package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getInstance();
		System.out.println("main�Լ������� �̱��� ��ü i��" + singObj.getI());
	}

}
