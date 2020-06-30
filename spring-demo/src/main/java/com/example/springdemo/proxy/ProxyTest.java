package com.example.springdemo.proxy;

import org.springframework.stereotype.Component;

/**
 * 不实现接口的类
 */

@Component
public class ProxyTest {

	public void hello(Class c) {
		System.out.println("hello cglib：" + c);
	}
}
