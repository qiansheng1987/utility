package com.example.springdemo.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		// 继承被代理类
		enhancer.setSuperclass(HelloServiceImpl.class);
		// 设置回调
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("before:" + method.getName());
				Object object = methodProxy.invokeSuper(o, objects);
				System.out.println("after：" + method.getName());
				return object;
			}
		});
		// 生成代理类对象
		HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
		helloService.sayHello();

	}
}
