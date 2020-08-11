package com.qiansheng.springbootjavadesignpatterns.producerAndConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>消费者</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1111:00
 */
public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

	private final ItemQueue queue;

	private final String name;

	public Consumer(String name, ItemQueue queue) {
		this.queue = queue;
		this.name = name;
	}

	public void consume() throws InterruptedException {
		Item item = queue.take();
		LOGGER.info("Consumer [{}] consume item [{}] produced by [{}]", name,
				item.getId(), item.getProducer());
	}
}
