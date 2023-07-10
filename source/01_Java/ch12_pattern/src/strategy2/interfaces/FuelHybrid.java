package strategy2.interfaces;

public class FuelHybrid implements FuellImpl {

	@Override
	public void fuel() {
		System.out.println("하이브리드를 사용합니다");
	}

}
