package com.example.springbootdemo;

import com.example.springbootdemo.customProperties.ConfigBean;
import com.example.springbootdemo.springConditional.ConditionController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
		//Arrays.stream(context.getBeanDefinitionNames()).forEach((t)-> System.out.println(t));
		String[] beanNames = context.getBeanNamesForType(ConditionController.class);
		System.out.println("beanNames=========================>" + Arrays.toString(beanNames));
	}

}
