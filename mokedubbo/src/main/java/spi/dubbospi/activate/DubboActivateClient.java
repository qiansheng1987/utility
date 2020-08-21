package spi.dubbospi.activate;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Filter;

import java.util.List;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/20 17:38
 */
public class DubboActivateClient {

	public static void main(String[] args) {

		ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
		URL url=new URL("","",3);
		List list=extensionLoader.getActivateExtension(url,new String[]{},Constants.PROVIDER);
		System.out.println(list);
	}
}
