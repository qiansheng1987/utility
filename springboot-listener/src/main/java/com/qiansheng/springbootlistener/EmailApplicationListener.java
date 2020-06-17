package com.qiansheng.springbootlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailApplicationListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof EmailEvent) {
			EmailEvent emailEvent = (EmailEvent) event;
			System.out.println("邮件地址：" + emailEvent.getAddress());
			System.out.println("邮件内容：" + emailEvent.getText());
		} else {
			System.out.println("系统本身事件"+ event.toString());
		}
	}
}
