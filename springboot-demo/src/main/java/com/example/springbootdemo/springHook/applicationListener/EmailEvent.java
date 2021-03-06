package com.example.springbootdemo.springHook.applicationListener;

import org.springframework.context.ApplicationEvent;

/**
 * 描述:自定义事件
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/21 15:33
 */
public class EmailEvent extends ApplicationEvent {

	private String author;

	private String content;

	private String date;

	public EmailEvent(Object source, String author, String content, String date) {
		super(source);
		this.author = author;
		this.content = content;
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
