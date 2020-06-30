package com.example.springdemo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	void getUserById(Integer id);
}
