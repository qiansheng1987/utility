package com.qs.patterns.singleton;

/**
 * 使用枚举实现单列
 */
public class SingletonUseEnum {

	private enum  SingletonEnum {

		INSTANCE;

		private final SingletonUseEnum singleton;

		SingletonEnum() {
			singleton = new SingletonUseEnum();
		}

		private SingletonUseEnum getInstance() {
			return singleton;
		}

	}

	private SingletonUseEnum() {

	}

	public static SingletonUseEnum getInstance() {
		return SingletonEnum.INSTANCE.getInstance();
	}
}
