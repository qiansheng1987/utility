package com.qiansheng.javaaqs.reentrantLock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述 <p> ReenTrantLock </p>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/6/18 15:24
 */
public class client {

	private static ReentrantLock lock  = new ReentrantLock();

	private static Integer count = 0;

	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	private static ExecutorService executorService1 = Executors.newSingleThreadExecutor();


	/*public static void main(String[] args) {
		for (int i = 0; i < 9 ; i++) {
			Thread t1 = new Thread() {
				@Override
				public void run() {
					executeTask();
				}
			};
			executorService.submit(t1);
		}
		executorService.shutdown();
	}*/

	/*public static void main(String[] args) {
		for (int i = 0; i < 9 ; i++) {
			Thread t1 = new Thread() {
				@Override
				public void run() {
					executeTask2();
				}
			};
			executorService1.submit(t1);
		}
		executorService1.shutdown();
	}*/

	public static void main(String[] args) {
		OrderThread t1 = new OrderThread(null, "A1");
		OrderThread t2 = new OrderThread(t1, "A2");
		OrderThread t3 = new OrderThread(t2, "A3");
		executorService.submit(t1);
		executorService.submit(t2);
		executorService.submit(t3);
		executorService.shutdown();
	}

	private static void executeTask() {
		lock.lock();
		try {
			System.out.println("线程："+Thread.currentThread().getName()+"执行线程任务" + count ++);
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private static void executeTask2() {
		System.out.println("线程："+Thread.currentThread().getName()+"执行线程任务" + count ++);
	}

	private static class OrderThread extends Thread {

		private Thread beforeThread;

		private String name;

		public OrderThread(Thread beforeThread, String name) {
			this.beforeThread = beforeThread;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				if (null != beforeThread) {
					beforeThread.join();
				}
				System.out.println(Thread.currentThread().getName() +"打印："+ name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



}

