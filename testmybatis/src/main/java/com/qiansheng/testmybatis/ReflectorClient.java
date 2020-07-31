package com.qiansheng.testmybatis;


import java.lang.reflect.Constructor;

class Computer{
	private String model;
	private String name;

	public Computer(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class ReflectorClient {
	public static void main(String[] args) {
		Constructor<?>[] declaredConstructors = Computer.class.getDeclaredConstructors();
		for (Constructor<?> con : declaredConstructors) {
			System.out.printf("con" + con);
		}
	}


}
