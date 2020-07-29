package com.qiansheng.testmybatis;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Inteceptor1 {

	Object plugin(Object target, InteceptorChain1 chain);
}

class InteceptorA1 implements Inteceptor1 {
	@Override
	public Object plugin(Object target, InteceptorChain1 chain) {
		System.out.println("InteceptorA1");
		return chain.plugin(target);
	}
}

class InteceptorB1 implements Inteceptor1 {
	@Override
	public Object plugin(Object target, InteceptorChain1 chain) {
		System.out.println("InteceptorB1");
		return target;
	}
}

class InteceptorC1 implements Inteceptor1 {
	@Override
	public Object plugin(Object target, InteceptorChain1 chain) {
		System.out.println("InteceptorC1");
		return target;
	}
}

class InteceptorChain1 {
	private List<Inteceptor1> inteceptors = new ArrayList<>();
	private Iterator<Inteceptor1> iterator;

	public List<Inteceptor1> getInteceptors() {
		return inteceptors;
	}

	public Object plugin(Object target) {
		if (null == iterator) {
			iterator = inteceptors.iterator();
		}
		if (iterator.hasNext()) {
			Inteceptor1 next = iterator.next();
			next.plugin(target, this);
		}
		return target;
	}

	public void addInteceptor(Inteceptor1 inteceptor) {
		inteceptors.add(inteceptor);
	}
}

public class PluginClient1 {

	public static void main(String[] args) {
		InteceptorChain1 inteceptorChain1 = new InteceptorChain1();
		inteceptorChain1.addInteceptor(new InteceptorA1());
		inteceptorChain1.addInteceptor(new InteceptorB1());
		inteceptorChain1.addInteceptor(new InteceptorC1());
		inteceptorChain1.plugin(new Object());
	}
}
