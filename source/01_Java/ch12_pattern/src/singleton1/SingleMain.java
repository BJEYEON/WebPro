package singleton1;

public class SingleMain {
	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance();
		obj1.setI(99);
		System.out.println(obj1.getI());
		System.out.println(obj2.getI());
	}

}
