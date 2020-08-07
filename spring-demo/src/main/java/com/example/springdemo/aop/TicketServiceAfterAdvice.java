package com.example.springdemo.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * <p>后置通知</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/79:55
 */
public class TicketServiceAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(method.getName() + "后置通知......");
	}
}
