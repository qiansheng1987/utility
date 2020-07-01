package com.qs.patterns.singleton;

/**
 * 功能描述 <p> 静态内部类实现方式
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/1 10:13
 */
public class Singleton3 {

	/**
	 * 静态内部类
	 */
	private static class SingletonInnerClass {
		public static final Singleton3 instance = new Singleton3();
	}

	private Singleton3 () {

	}

	public static Singleton3 getInstance() {
		return SingletonInnerClass.instance;
	}
}
