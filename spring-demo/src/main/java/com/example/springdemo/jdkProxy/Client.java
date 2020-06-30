package com.example.springdemo.jdkProxy;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {

		Subject subject = new RealSubject();
		ClassLoader classLoader = subject.getClass().getClassLoader();
		Class<?>[] interfaces = subject.getClass().getInterfaces();
		Subject object = (Subject) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandlerImpl(subject));
		System.out.println("动态代理对象的类型:" + object.getClass().getName());
		String reVal = object.SayHello("qiansheng");
		System.out.println(reVal);
	}
}
