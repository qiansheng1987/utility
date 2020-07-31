package com.example.springdemo.cycleReferenceOfSpring;

@FunctionalInterface
public interface CarFactory<T> {

	T getObject();
}
