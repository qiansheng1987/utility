package spi.dubbospi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/19 9:47
 */
public class Client {

	public static void main(String[] args) {
		ExtensionLoader<MessageService> extensionLoader = ExtensionLoader.getExtensionLoader(MessageService.class);
		MessageService email = extensionLoader.getExtension("email");
		email.sendMsg("dubbo spi email send msg");
		MessageService sms = extensionLoader.getExtension("sms");
		sms.sendMsg("dubbo spi sms send");
	}
}
