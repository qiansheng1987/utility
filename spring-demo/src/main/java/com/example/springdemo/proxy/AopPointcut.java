package com.example.springdemo.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 生命注解作用在方法上面
@Retention(RetentionPolicy.RUNTIME) // 注解保留至运行时
public @interface AopPointcut {
}
