package com.example.springbootdemo.springConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:client
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/18 16:37
 */
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigA.class);
		Car car = (Volkswagen)context.getBean("Volkswagen");
		car.print();
	}
}
