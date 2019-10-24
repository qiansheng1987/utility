package com.example.springbootdemo.springConditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:<p></p>
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/24 14:09
 */

@RestController
@Conditional(ControllerConditional.class)
public class ConditionController {

	@RequestMapping("/condition")
	public String condition() {
		return "OK";
	}
}
