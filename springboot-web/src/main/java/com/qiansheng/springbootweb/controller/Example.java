package com.qiansheng.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example {

	@RequestMapping(value ="/home", method = RequestMethod.GET)
	@ResponseBody
	public String home(){
		return "tomcat81>>>>>你好，Spring Boot";
	}
}
