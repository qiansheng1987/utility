package com.example.springdemo.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <p>前置通知</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/79:46
 */
public class TicketServiceBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(method.getName() + "前置通知......");
	}
}
