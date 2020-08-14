package com.qiansheng.springbootrocketmq.orderedmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * <p>有序消息生产者</p>
 *
 * 要保证消息的顺序性，在发送消息时，这一组消息必须发送到同一个queue中。（一个broker默认4个queue）。
 * 在上面的代码中，orderId表示一个订单号。
 * 在send方法中实现了一个选择器。这个选择器的作用就是根据orderId对queue的数量取模，
 * 保证同一个orderId的所有消息落到同一个queue上。
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1016:24
 */
public class OrderedProducer {

	public static void main(String[] args) throws Exception {
		DefaultMQProducer producer = new DefaultMQProducer("orderedMessageProduceGroup");
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		for (int i = 0; i < 10; i++) {
			int orderId = 0;
			Message msg = new Message("qianshengOrderedMessageTopic", "TagA",
					"KEY" + i, ("OrderedMessage" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
			SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
				@Override
				public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
					Integer id = (Integer) arg;
					int index = id % mqs.size();
					return mqs.get(index);
				}
			}, orderId);
			System.out.printf("%s%n", sendResult);
		}
		producer.shutdown();
	}
}
