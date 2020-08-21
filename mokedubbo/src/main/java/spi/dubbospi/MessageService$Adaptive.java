package spi.dubbospi;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class MessageService$Adaptive implements spi.dubbospi.MessageService {
	public void sendMsg(java.lang.String arg0) {throw new UnsupportedOperationException("method public abstract void spi.dubbospi.MessageService.sendMsg(java.lang.String) of interface spi.dubbospi.MessageService is not adaptive method!");
	}
	public void sendMsg(com.alibaba.dubbo.common.URL arg0, java.lang.String arg1) {
		if (arg0 == null) throw new IllegalArgumentException("url == null");
		com.alibaba.dubbo.common.URL url = arg0;
		String extName = url.getParameter("messageKey", "email");
		if(extName == null) throw new IllegalStateException("Fail to get extension(spi.dubbospi.MessageService) name from url(" + url.toString() + ") use keys([message.service])");
		spi.dubbospi.MessageService extension = (spi.dubbospi.MessageService)ExtensionLoader.getExtensionLoader(spi.dubbospi.MessageService.class).getExtension(extName);extension.sendMsg(arg0, arg1);
	}
}
