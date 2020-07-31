package com.example.springdemo.cycleReferenceOfSpring;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		A a = (A)context.getBean("A");
		System.out.printf(JSON.toJSONString(a));
	}
}
