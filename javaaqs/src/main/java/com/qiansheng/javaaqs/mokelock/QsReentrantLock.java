package com.qiansheng.javaaqs.mokelock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>同步锁</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/21 10:26
 */
public class QsReentrantLock {

	/**
	 * 标识，是否线程获取到锁
	 */
	private volatile int status = 0;

	public void lock() {
		while (!compareAndSet(0, 1)) {

		}
		// 继续执行
	}

	public void unlock() {
		status = 0;
	}

	boolean compareAndSet(int expectValue, int newValue) {
		return false;
	}

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
	}
}
