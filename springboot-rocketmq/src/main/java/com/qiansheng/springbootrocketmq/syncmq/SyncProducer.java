package com.qiansheng.springbootrocketmq.syncmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * <p>同步消息生产者</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1015:23
 */
public class SyncProducer {

	public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
		DefaultMQProducer producer = new DefaultMQProducer("produce1");
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.setVipChannelEnabled(false);
		//启动实例
		producer.start();
		for (int i = 0; i < 10; i++) {
			Message msg = new Message("qianshengSyncMqTopicTest", "TagA",
					("Hello world" + i ).getBytes(RemotingHelper.DEFAULT_CHARSET));
			SendResult sendResult = producer.send(msg);
			System.out.printf("%s%n", sendResult);
		}
	}
}
