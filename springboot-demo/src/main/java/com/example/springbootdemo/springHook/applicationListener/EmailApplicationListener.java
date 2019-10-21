package com.example.springbootdemo.springHook.applicationListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 描述:自定义事件监听
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 15:35
 */

@Component
public class EmailApplicationListener implements ApplicationListener<EmailEvent> {

	@Override
	public void onApplicationEvent(EmailEvent event) {
		System.out.println("EmailApplicationListener callback!!");
		System.out.println("EmailEvent --> source: " + event.getSource());
		System.out.println("EmailEvent --> author: " + event.getAuthor());
		System.out.println("EmailEvent --> content: " + event.getContent());
		System.out.println("EmailEvent --> date: " + event.getDate());
	}
}
