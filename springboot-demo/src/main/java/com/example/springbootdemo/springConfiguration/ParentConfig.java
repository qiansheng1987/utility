package com.example.springbootdemo.springConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 描述:<p></p>
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/18 16:44
 */
@Configuration
@Import({JavaConfigA.class})
public class ParentConfig {
}
