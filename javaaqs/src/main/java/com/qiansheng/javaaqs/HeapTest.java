package com.qiansheng.javaaqs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class HeapTest {

	byte[] a = new byte[1024*100]; //100kb

	public static void main(String[] args) {
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext();
		con.getBean("rest");
		ArrayList<HeapTest> heapTests = new ArrayList<>();
		while (true) {
			heapTests.add(new HeapTest());
		}


	}

}
