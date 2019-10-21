package com.example.springbootdemo.springHook.importBeanDefinitionRegistrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {EnableThrowableRegistrar.class})
public @interface EnableThrowable {

	Class<?>[] targets() default {};
}
