package com.qiansheng.testmybatis;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义代理植入点，
 */
interface Inteceptor {
	Object plugin(Object target);
}

class InteceptorA implements Inteceptor {
	@Override
	public Object plugin(Object target) {
		System.out.println("InteceptorA");
		return target;
	}
}

class InteceptorB implements Inteceptor {
	@Override
	public Object plugin(Object target) {
		System.out.println("InteceptorB");
		return target;
	}
}

class InteceptorC implements Inteceptor {
	@Override
	public Object plugin(Object target) {
		System.out.println("InteceptorC");
		return target;
	}
}

class InteceptorChain {
	private List<Inteceptor> inteceptors = new ArrayList<>();

	public List<Inteceptor> getInteceptors() {
		return inteceptors;
	}

	public Object pluginAll(Object target) {
		for (Inteceptor inteceptor : inteceptors) {
			inteceptor.plugin(target);
		}
		return target;
	}

	public void addInteceptor(Inteceptor inteceptor) {
		inteceptors.add(inteceptor);
	}



}
public class PluginClient {

	public static void main(String[] args) {
		InteceptorChain inteceptorChain = new InteceptorChain();
		inteceptorChain.addInteceptor(new InteceptorA());
		inteceptorChain.addInteceptor(new InteceptorB());
		inteceptorChain.addInteceptor(new InteceptorC());
		inteceptorChain.pluginAll(new Object());

	}
}
