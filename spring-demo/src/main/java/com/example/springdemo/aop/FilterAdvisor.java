package com.example.springdemo.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * <p>实现一个PointcutAdvisor，通过提供的Pointcut对Advice进行过滤</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/713:34
 */
public class FilterAdvisor implements PointcutAdvisor {

	private Pointcut pointcut;

	private Advice advice;

	public FilterAdvisor(Pointcut pointcut, Advice advice) {
		this.pointcut = pointcut;
		this.advice = advice;
	}

	@Override
	public Pointcut getPointcut() {
		return this.pointcut;
	}

	@Override
	public Advice getAdvice() {
		return this.advice;
	}

	@Override
	public boolean isPerInstance() {
		return false;
	}
}
