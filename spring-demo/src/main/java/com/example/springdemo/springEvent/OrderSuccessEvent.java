package com.example.springdemo.springEvent;

import org.springframework.context.ApplicationEvent;

public class OrderSuccessEvent extends ApplicationEvent {

	public OrderSuccessEvent(Object source) {
		super(source);
	}
}
