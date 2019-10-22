package com.example.springbootdemo.customProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 描述: 配置属性bean
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 14:46
 */

@Configuration
@ConfigurationProperties(prefix = "com.depth")
//指定自定义配置文件
@PropertySource("classpath:customProp.properties")
public class ConfigBeanTest {

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
