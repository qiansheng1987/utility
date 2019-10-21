package com.example.springbootdemo.springHook.postProcessor;

import org.springframework.stereotype.Component;

/**
 * 描述:<p></p>
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 15:13
 */

@Component
public class PostBean {

	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void sayHello() {
		System.out.println(String.format("author %s say hello!", author));
	}
}
