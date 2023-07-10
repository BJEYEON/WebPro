package singleton1;

public class Single {
	private int i;
	private static Single INSTANCE = new Single();
	public Single() {
		
	}
	public static Single getInstance() {
		return INSTANCE;
	}
//	private static Single INSTANCE;
//	private Single() {
//		
//	}
//	public static Single getInstance() {
//		//Single 형 객체를 생성한 적 없으면 객체생성
//		if (INSTANCE == null) {
//			INSTANCE = new Single();
//		}
//		return INSTANCE;
//	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
		
	}
	

}
