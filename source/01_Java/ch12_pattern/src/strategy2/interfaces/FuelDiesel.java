package strategy2.interfaces;

public class FuelDiesel implements FuellImpl {

	@Override
	public void fuel() {
		System.out.println("경유 연료를 사용합니다");
	}

}
