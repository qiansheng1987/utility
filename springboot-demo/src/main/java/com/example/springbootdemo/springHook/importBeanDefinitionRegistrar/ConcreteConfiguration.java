package com.example.springbootdemo.springHook.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.Configuration;

/**
 * 描述:java配置类
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 14:24
 */
@Configuration
@EnableThrowable(targets = {ConcreteService.class})
public class ConcreteConfiguration {
}
