package com.example.springdemo.cycleReferenceOfSpring;

import com.alibaba.fastjson.JSON;

public class CarFactoryClient {

	private <T> T getObject(CarFactory<T> carFactory) {
		return carFactory.getObject();
	}

	public static void main(String[] args) {
		CarFactoryClient client = new CarFactoryClient();
		Car bmw = client.getObject(() -> {
			Car car = new Car();
			car.setModel("BMW");
			car.setPrice("444444");
			return car;
		});
		System.out.printf(JSON.toJSONString(bmw));
	}
}
