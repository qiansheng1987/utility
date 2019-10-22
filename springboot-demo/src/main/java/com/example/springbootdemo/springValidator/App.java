package com.example.springbootdemo.springValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.Set;

/**
 * 描述:client
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 13:52
 */
public class App {
	public static void main(String[] args) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		User user = new User();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for (ConstraintViolation<User> constraintViolation : constraintViolations) {
			System.out.println("constraintViolation.getMessage()--->" + constraintViolation.getMessage());
			System.out.println("constraintViolation.getMessageTemplate()--->" + constraintViolation.getMessageTemplate());
			System.out.println("constraintViolation.getPropertyPath()--->" + constraintViolation.getPropertyPath());
			ConstraintDescriptor descriptor = constraintViolation.getConstraintDescriptor();
			System.out.println("descriptor.getAnnotation()--->" + descriptor.getAnnotation());
		}
	}
}
