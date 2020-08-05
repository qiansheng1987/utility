package com.example.springdemo.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ApplicationListener<OrderSuccessEvent> {

	@Override
	public void onApplicationEvent(OrderSuccessEvent event) {
		startCar();
	}

	private void startCar() {
		System.out.println("开始发车实现方式1!");
	}
}
