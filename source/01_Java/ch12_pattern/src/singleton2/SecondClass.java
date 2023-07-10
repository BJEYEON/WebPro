package singleton2;

public class SecondClass {
	public SecondClass() {
		System.out.println("SecondClass 생성자 실행중 --------------");
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("싱글톤 객체의 i값은 " + singletonObject.getI());
		System.out.println("SecondClass 생성자 실행 끝-------------");
	}

}
