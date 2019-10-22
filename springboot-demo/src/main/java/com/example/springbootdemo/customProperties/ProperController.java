package com.example.springbootdemo.customProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:自定义属性Controller
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 14:41
 */

@RestController
public class ProperController {

	@Value("${com.qs.name}")
	private String name;

	@Value("${com.qs.age}")
	private int age;

	@Autowired
	private ConfigBean configBean;

	@Autowired
	private ConfigBeanTest configBeanTest;

	@RequestMapping("/propTest")
	public String hello(){
		return name+ "," + age;
	}

	@RequestMapping("/configBean")
	public String configBean(){
		return configBean.getName()+ "===and=== " + configBean.getAge();
	}

	@RequestMapping("/configBeanTest")
	public String configBeanTest(){
		return configBeanTest.getName()+ "===and=== " + configBeanTest.getAge();
	}
}
