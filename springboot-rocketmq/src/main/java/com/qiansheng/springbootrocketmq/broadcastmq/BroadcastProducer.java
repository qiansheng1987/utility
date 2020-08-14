package com.qiansheng.springbootrocketmq.broadcastmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * <p>广播消息，消息被可以被所有的订阅者消费</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1016:59
 */
public class BroadcastProducer {

	public static void main(String[] args) throws Exception {
		DefaultMQProducer producer = new DefaultMQProducer("broadcastProduceGroup");
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();

		for (int i = 0; i < 10; i++) {
			Message msg = new Message("broadcastTopic",
					"TagA",
					"OrderID188",
					"Hello world".getBytes());
			SendResult sendResult = producer.send(msg);
			System.out.printf("%s%n", sendResult);
		}
		producer.shutdown();
	}
}
