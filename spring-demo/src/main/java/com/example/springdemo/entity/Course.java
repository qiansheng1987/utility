package com.example.springdemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {


	private static final long serialVersionUID = 178973323021132560L;


	private Integer id;

	private String name;
}
