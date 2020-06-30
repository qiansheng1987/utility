package com.example.springdemo.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
//@EnableAspectJAutoProxy
@Aspect
@Component
public class AspectHandler {

	@Pointcut("@annotation(com.example.springdemo.proxy.AopPointcut)")
	public void pointcut() {

	}
	@Before("pointcut()")
	public void before() {
		System.out.println("Aspect before...");
	}

	@Before("pointcut()")
	public void after() {
		System.out.println("Aspect after .....");
	}
}
