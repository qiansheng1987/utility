package com.example.springdemo.proxy;

import org.springframework.stereotype.Component;

@Component
public class JdkProxyTestImpl implements JdkProxyTest {
	@Override
	public void hello(Class c) {
		System.out.println("hello jdk: " + c);
	}
}
