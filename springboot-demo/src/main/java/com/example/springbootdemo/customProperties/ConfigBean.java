package com.example.springbootdemo.customProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述: 配置属性bean
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 14:46
 */

@ConfigurationProperties(prefix = "com.qs")
public class ConfigBean {

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
