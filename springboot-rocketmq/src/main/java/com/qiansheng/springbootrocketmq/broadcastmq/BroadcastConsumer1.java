package com.qiansheng.springbootrocketmq.broadcastmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * <p>广播消息的消费者</p>
 *
 * 启动BroadcastConsumer1，BroadcastConsumer2，BroadcastProducer。
 * 可以看到两个consumer都消费了10个消息。
 *
 * 将consumer的consumer.setMessageModel(MessageModel.BROADCASTING);注释掉。
 * 再测试一次，可以发现两个consumer分别消费了部分消息。
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1017:01
 */
public class BroadcastConsumer1 {

	public static void main(String[] args) throws Exception {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcastConsumerGroup");
		consumer.setNamesrvAddr("127.0.0.1:9876");
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		//set to broadcast mode
		consumer.setMessageModel(MessageModel.BROADCASTING);

		consumer.subscribe("broadcastTopic", "TagA || TagC || TagD");

		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
															ConsumeConcurrentlyContext context) {
				System.out.printf(Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		consumer.start();
		System.out.printf("Broadcast Consumer Started.%n");
	}
}
