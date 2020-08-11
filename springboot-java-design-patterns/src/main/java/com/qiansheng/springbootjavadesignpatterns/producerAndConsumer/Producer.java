package com.qiansheng.springbootjavadesignpatterns.producerAndConsumer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>生产者</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1110:56
 */
public class Producer {

	private static final Random RANDOM = new Random();

	AtomicInteger num = new AtomicInteger(1);

	private final ItemQueue queue;

	private final String name;

	public Producer(String name, ItemQueue itemQueue) {
		this.queue = itemQueue;
		this.name = name;
	}

	public void produce() throws InterruptedException {
		Item item = new Item(name, num.getAndIncrement());
		queue.put(item);
		// Thread.sleep(RANDOM.nextInt(2000));
	}
}
