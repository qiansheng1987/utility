package com.qiansheng.javaaqs;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
public class JvmClient {

	private static final int initData = 666;
	private static User user = new User();


	public int computer() {
		int a = 1;
		int b = 2;
		int c = (a + b) * 10;
		return c;
	}

	public static void main(String[] args) {
		JvmClient client = new JvmClient();
		client.computer();
		System.out.printf("test");
	}

}
