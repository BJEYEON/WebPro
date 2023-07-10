package strategy2.interfaces;

public class FuelGasoline implements FuellImpl {

	@Override
	public void fuel() {
		System.out.println("휘발유 연료를 사용합니다");
	}

}
