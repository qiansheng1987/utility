package com.example.springdemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -5496457244941884L;

	private Integer id;

	private String userName;

	private String passWord;

	private String realName;

	private Course course;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
