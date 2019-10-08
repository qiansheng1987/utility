package com.qs.patterns.Mediator;

/**
 * 描述:抽象同事类
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/8 10:13
 */
public abstract class AbstractColleague {

	protected int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public abstract void setNumber(int number, AbstractMediator am);
}
