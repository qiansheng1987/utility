package com.qiansheng.springbootjavadesignpatterns.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>有界队列</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1110:51
 */
public class ItemQueue {

	private BlockingQueue<Item> queue;

	public ItemQueue() {
		queue = new LinkedBlockingQueue<>(5);
	}

	public void put(Item item) throws InterruptedException {
		queue.put(item);
	}

	public Item take() throws InterruptedException {
		return queue.take();
	}


}
