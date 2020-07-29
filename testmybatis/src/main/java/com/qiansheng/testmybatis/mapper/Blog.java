package com.qiansheng.testmybatis.mapper;

import java.io.Serializable;

public class Blog implements Serializable {


	private static final long serialVersionUID = -8608013867387634985L;

	private Integer id;

	private String name;

	public Blog(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
