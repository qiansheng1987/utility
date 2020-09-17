package com.qiansheng.javaaqs.deadlock;

/**
 * <p>死锁，jstack分析</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/17 16:08
 */
public class Client {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		Thread thread1 = new Thread(() -> {
			synchronized (obj1) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("=============thread1 execute============");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (obj2) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println("=============thread2 execute============");
				}
			}
		});

		thread1.start();
		thread2.start();
	}


}
