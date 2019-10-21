package com.example.springbootdemo.springConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:<p></p>
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/18 16:35
 */

@Configuration
public class JavaConfigA {

	@Bean(name="Volkswagen")
	public Car getVolkswagen(){
		return new Volkswagen();
	}
}
