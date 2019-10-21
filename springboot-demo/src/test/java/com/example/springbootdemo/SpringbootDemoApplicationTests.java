package com.example.springbootdemo;

import com.example.springbootdemo.springHook.importBeanDefinitionRegistrar.ConcreteService;
import com.example.springbootdemo.springHook.applicationListener.EmailEvent;
import com.example.springbootdemo.springHook.postProcessor.PostBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringbootDemoApplicationTests {

	@Autowired
	private ConcreteService concreteService;

	@Autowired
	private PostBean postBean;

	@Autowired
	ApplicationContext applicationContext;

	@Test
	public void print() throws Exception{
		concreteService.print();
	}

	@Test
	public void postProcessorSayHello() {
		postBean.sayHello();
	}

	@Test
	public void applicationListenerTest() {
		applicationContext.publishEvent(new EmailEvent("this is source",
				"throwable","here is emailEvent","2017-5-16"));
	}

}
