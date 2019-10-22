package com.example.springbootdemo.springValidator;

import com.example.springbootdemo.springValidator.customValidator.IsMobile;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 描述:实体
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/22 11:04
 */
public class User {

	@NotNull
	@Size(min = 2, max = 30, message = "请检查长度有问题")
	private String name;

	@NotNull
	@Min(18)
	private Integer age;

	@IsMobile
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
