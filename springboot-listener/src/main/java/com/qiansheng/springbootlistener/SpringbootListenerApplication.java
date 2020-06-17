package com.qiansheng.springbootlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootListenerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootListenerApplication.class, args);
		context.publishEvent(new EmailEvent("hello","124@qq.com", "qeeee"));
	}

}
