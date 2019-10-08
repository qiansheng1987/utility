package com.qs.patterns.Mediator;

/**
 * 描述:抽象的中介者
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/8 10:16
 */
public abstract class AbstractMediator {

	protected AbstractColleague A;

	protected AbstractColleague B;

	public AbstractMediator(AbstractColleague a, AbstractColleague b) {
		A = a;
		B = b;
	}

	public abstract void AaffectB();

	public abstract void BaffectA();
}
