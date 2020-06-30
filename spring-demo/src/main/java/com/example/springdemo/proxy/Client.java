package com.example.springdemo.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Client {

	@Autowired
	ProxyTest proxyTest;

	@Autowired
	JdkProxyTest jdkProxyTest;

	@Test
	public void hello() {
		System.out.println("不实现接口的类");
		proxyTest.hello(proxyTest.getClass());
		System.out.println("-------------------------");
		System.out.println("实现接口的类");
		jdkProxyTest.hello(jdkProxyTest.getClass());
	}
}






















