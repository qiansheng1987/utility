package com.qiansheng.javaaqs.threadcooperation;

/**
 * <p>在一个线程内部调用列外一个线程的join，则会将当前线程挂起，知道列外一个线程执行完成在执行</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/24 10:50
 */
public class Client {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB(threadA);
		threadB.start();
		threadA.start();
	}
}
