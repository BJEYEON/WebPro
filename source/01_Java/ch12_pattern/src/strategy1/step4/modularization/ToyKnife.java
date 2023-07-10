package strategy1.step4.modularization;

import strategy1.step4.interfaces.KnifeImpl;

public class ToyKnife implements KnifeImpl {

	@Override
	public void knife() {
		System.out.println("장난감 검으로 업그레이드 되었습니다.");

	}

}
