package com.qiansheng.javaaqs.mokelock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/21 10:43
 */
public class TestPark {

	private static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		Thread t1 = new Thread( () -> {testSync();});
		t1.setName("t1");
		t1.start();

		Thread t2 = new Thread( () -> {testSync();});
		t2.setName("t2");
		t2.start();


	}

	public static void testSync() {
		System.out.println(Thread.currentThread().getName());
		lock.lock();
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
