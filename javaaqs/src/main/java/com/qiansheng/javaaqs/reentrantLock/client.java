package com.qiansheng.javaaqs.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述 <p> ReenTrantLock </p>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/6/18 15:24
 */
public class client {

	private static ReentrantLock lock  = new ReentrantLock();

	public static void main(String[] args) {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				executeTask();
			}
		};
		t1.setName("t1");

		Thread t2 = new Thread() {
			@Override
			public void run() {
				executeTask();
			}
		};
		t2.setName("t2");

		t2.start();
		t1.start();


	}

	private static void executeTask() {
		lock.lock();
		try {
			if (Thread.currentThread().getName().equals("t1")) {
				Thread.sleep(2000000000);
			}
			System.out.println("线程："+Thread.currentThread().getName()+"执行线程任务");
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}


}

