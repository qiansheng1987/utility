package com.qs.patterns.Mediator;

/**
 * 描述:具体中介者
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/8 10:20
 */
public class Mediator extends AbstractMediator {

	public Mediator(AbstractColleague a, AbstractColleague b) {
		super(a, b);
	}

	@Override
	public void AaffectB() {
		int number = A.getNumber();
		B.setNumber(number * 100);
	}

	@Override
	public void BaffectA() {
		int number = B.getNumber();
		A.setNumber(number / 100);
	}
}
