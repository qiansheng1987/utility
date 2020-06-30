package com.example.springdemo.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器实现类
 */
class InvocationHandlerImpl implements InvocationHandler {

	/**
	 * 需要代理的类
	 */
	private Object subject;

	public InvocationHandlerImpl(Object subject) {
		this.subject = subject;
	}

	/**
	 * 该方法负责集中处理动态代理类上的所有方法调用。
	 * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
	 *
	 * @param proxy  代理类实例
	 * @param method 被调用的方法对象
	 * @param args   调用参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		//在代理真实对象前我们可以添加一些自己的操作
		System.out.println("在调用之前，处理逻辑");

		System.out.println("Method:" + method);

		Object returnValue = method.invoke(subject, args);

		//在代理真实对象后我们也可以添加一些自己的操作
		System.out.println("在调用之后，处理逻辑");

		return returnValue;
	}


}
