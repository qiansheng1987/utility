package com.qiansheng.javaaqs.threadcooperation;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/24 10:46
 */
public class ThreadA extends Thread{

	@Override
	public void run() {
		System.out.println("执行线程A.......");
	}
}
