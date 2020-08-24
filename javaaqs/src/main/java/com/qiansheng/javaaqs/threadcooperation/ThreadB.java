package com.qiansheng.javaaqs.threadcooperation;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/24 10:47
 */
public class ThreadB extends Thread {

	private ThreadA threadA;

	public ThreadB(ThreadA threadA) {
		this.threadA = threadA;
	}

	@Override
	public void run() {
		try {
			threadA.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("执行线程B........");
	}
}
