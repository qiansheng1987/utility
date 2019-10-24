package com.example.springbootdemo.springConditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 描述:自定义condition
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/24 14:03
 */
public class ControllerConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return false;
	}
}
