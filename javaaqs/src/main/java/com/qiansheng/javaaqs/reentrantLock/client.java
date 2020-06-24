package com.qiansheng.javaaqs.reentrantLock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述 <p> ReenTrantLock </p>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/6/18 15:24
 */
public class client {

	public static void main(String[] args) {
		AtomicInteger inc = new AtomicInteger();
		inc.incrementAndGet();
	}

	@Test
	public void testReentrantLock() {
		ReentrantLock lock  = new ReentrantLock();
		lock.lock();
		try {
			if (lock.tryLock(15, TimeUnit.SECONDS)) {
				// 处理逻辑
				System.out.println("获得锁.....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

