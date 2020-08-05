package com.example.springdemo.springEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements ApplicationListener<OrderSuccessEvent> {

	@Override
	public void onApplicationEvent(OrderSuccessEvent event) {
		sendSms();
	}

	private void sendSms() {
		System.out.println("发送sms消息!");
	}
}
