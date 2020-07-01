package com.qs.patterns.singleton;

/**
 * 懒汉式
 */
public class Singleton {

	private static Singleton singleton;

	private Singleton() {
	}

	public static synchronized Singleton getInstance() {
		if (null == singleton) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
