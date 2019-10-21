package com.example.springbootdemo.springHook.importBeanDefinitionRegistrar;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 描述:<p></p>
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 14:06
 */
public class EnableThrowableRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println(String.format("JAVA_HOME:%S", environment.getProperty("JAVA_HOME")));
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		Map<String, Object> annotationAttributes =
				importingClassMetadata.getAnnotationAttributes(EnableThrowable.class.getCanonicalName());
		Class<?>[] targets = (Class<?>[])annotationAttributes.get("targets");
		if (null != targets && targets.length > 0) {
			for (Class<?> target : targets) {
				BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(target).getBeanDefinition();
				registry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
			}
		}
	}
}






















