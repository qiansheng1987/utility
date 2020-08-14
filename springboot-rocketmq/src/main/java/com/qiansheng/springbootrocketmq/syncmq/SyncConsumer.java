package com.qiansheng.springbootrocketmq.syncmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * <p>同步消息消费者</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1015:40
 */
public class SyncConsumer {

	public static void main(String[] args) throws MQClientException {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer1");
		consumer.setNamesrvAddr("127.0.0.1:9876");
		consumer.setVipChannelEnabled(false);
		//这里设置的是一个consumer的消费策略
		//CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，即跳过历史消息
		//CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
		//CONSUME_FROM_TIMESTAMP 从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认是半个小时以前
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		consumer.subscribe("qianshengSyncMqTopicTest", "TagA");

		// 设置一个listener，主要进行消费逻辑的处理
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
				//返回消费状态
				//CONSUME_SUCCESS 消费成功
				//RECONSUME_LATER 消费失败，需要稍后重新消费
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		//调用start()方法启动consumer
		consumer.start();
		System.out.println("Consumer Started.");

	}

}
