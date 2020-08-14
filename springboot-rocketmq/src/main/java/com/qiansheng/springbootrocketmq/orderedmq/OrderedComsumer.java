package com.qiansheng.springbootrocketmq.orderedmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Random;

/**
 * <p>有序消息消费者</p>
 *
 * 保证生产者保证了生产端的消息顺序性，那么消费端必须保证消息被顺序的消费。使用MessageListenerOrderly。
 * 作用是，必须等前面的消息消费完，后面的消息才能进行消费。
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1016:37
 */
public class OrderedComsumer {

	public static void main(String[] args) throws  Exception {

		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("orderedMessageConsumeGroup");
		consumer.setNamesrvAddr("127.0.0.1:9876");
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		consumer.subscribe("qianshengOrderedMessageTopic", "TagA");
		Random random = new Random(10);
		consumer.registerMessageListener(new MessageListenerOrderly() {
			@Override
			public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
				context.setAutoCommit(true);
				for (MessageExt msg : msgs) {
					System.out.printf(Thread.currentThread().getName() + "Receive new Messages:" + new String(msg.getBody()) + "%n");
					try {
						Thread.sleep(random.nextInt());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return ConsumeOrderlyStatus.SUCCESS;
			}
		});
		consumer.start();
		System.out.printf("Consumer Started.%n");
	}





}
