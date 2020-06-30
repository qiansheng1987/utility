package com.example.springdemo.jdkProxy;

public class RealSubject implements Subject {

	@Override
	public String SayHello(String name) {
		return "hello " + name;
	}

	@Override
	public String SayGoodBye() {
		return "good bye";
	}
}
