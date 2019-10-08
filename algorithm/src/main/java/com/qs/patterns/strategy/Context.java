package com.qs.patterns.strategy;

/**
 * 描述:封装类：也叫上下文，对策略进行二次封装，目的是避免高层模块对策略的直接调用。
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/8 10:41
 */
public class Context {

	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}

	public void execute() {
		strategy.doSomething();
	}
}
