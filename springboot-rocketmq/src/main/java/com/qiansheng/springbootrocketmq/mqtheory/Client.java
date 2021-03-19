package com.qiansheng.springbootrocketmq.mqtheory;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/29 16:16
 */
public class Client {

	public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
		MQProducer producer = getMqProducer();
		for (int i = 0; i < 10; i++) {
			Message message = new Message();
			message.setTopic("topic"+i);
			message.setBody(("qiansheng的博客").getBytes());
			SendResult send = producer.send(message);
		}
		producer.shutdown();
	}

	private static DefaultMQProducer getMqProducer() {
		DefaultMQProducer producer = new DefaultMQProducer("qsProducerGroup");
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.setVipChannelEnabled(false);
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
		return producer;
	}


}
