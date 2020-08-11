package com.qiansheng.springbootjavadesignpatterns.producerAndConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>client</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1111:02
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(11);
		ItemQueue itemQueue = new ItemQueue();

		for (int i = 0; i < 10; i++) {
			Producer producer = new Producer("Producer_" + i, itemQueue);
			executorService.submit(() -> {
				while (true) {
					producer.produce();
				}
			});
		}

		for (int i = 0; i < 1; i++) {
			Consumer consumer = new Consumer("Consumer_" + i, itemQueue);
			executorService.submit(() -> {
				while (true) {
					consumer.consume();
				}
			});
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(10, TimeUnit.SECONDS);
			executorService.shutdownNow();
		} catch (InterruptedException e) {
			LOGGER.error("Error waiting for ExecutorService shutdown");
		}
	}
}
