package com.example.springbootdemo.springValidator.customValidator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:自定义注解的实现类
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 11:26
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

	public static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return false;
		}
		Matcher matcher = MOBILE_PATTERN.matcher(value);
		return matcher.matches();
	}

	@Override
	public void initialize(IsMobile constraintAnnotation) {

	}
}
