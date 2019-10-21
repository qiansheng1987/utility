package com.example.springbootdemo.springHook.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 描述:实现了BeanPostProcessor可以在bean实例化之后，初始化之前做一些自定义的操作
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 15:03
 */

@Component
public class ConcreteBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.contains("postBean")) {
			System.out.println(String.format("Bean初始化之前,bean:%s,beanName:%s", bean.toString(), beanName));
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.contains("postBean")) {
			System.out.println(String.format("Bean初始化之后,bean:%s,beanName:%s", bean.toString(), beanName));
		}
		return bean;
	}
}
