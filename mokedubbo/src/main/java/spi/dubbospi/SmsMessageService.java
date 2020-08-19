package spi.dubbospi;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/19 9:46
 */
@Activate
public class SmsMessageService implements MessageService {

	@Override
	public void sendMsg(String messageBody) {
		System.out.println("SmsMessageService send message:" + messageBody);
	}
}
