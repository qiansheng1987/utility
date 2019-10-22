package com.example.springbootdemo.springValidator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 描述:测试Controller
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 11:07
 */

@RestController
public class SpringValidatorController {

	@InitBinder
	public void initBinder() {
	}

	@RequestMapping("/test")
	public Object validateTest(@Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ObjectError> objectErrors =  bindingResult.getAllErrors();
			for (ObjectError objectError : objectErrors) {
				System.out.println(objectError.getObjectName() + objectError.getDefaultMessage());
			}
			return bindingResult.getAllErrors();
		}
		return "OK";
	}
}
























