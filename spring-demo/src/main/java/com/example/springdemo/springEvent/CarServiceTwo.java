package com.example.springdemo.springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CarServiceTwo {

	@EventListener(OrderSuccessEvent.class)
	private void startCar() {
		System.out.println("开始发车实现方式2!");
	}
}
