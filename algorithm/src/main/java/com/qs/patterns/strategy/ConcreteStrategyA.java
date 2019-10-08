package com.qs.patterns.strategy;

/**
 * 描述:具体策略A
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/8 10:40
 */
public class ConcreteStrategyA implements IStrategy{

	@Override
	public void doSomething() {
		System.out.println("具体策略A");
	}
}
