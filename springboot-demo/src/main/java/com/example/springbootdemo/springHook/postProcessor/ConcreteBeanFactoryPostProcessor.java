package com.example.springbootdemo.springHook.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 描述:实现了BeanFactoryPostProcessor的类在Spring容器加载了bean的定义文件之后，在bean实例化之前执行
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 15:07
 */
@Component
public class ConcreteBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("postBean");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		propertyValues.addPropertyValue("author", "throwable");
	}
}
