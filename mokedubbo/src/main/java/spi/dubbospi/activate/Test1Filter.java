package spi.dubbospi.activate;

import com.alibaba.dubbo.rpc.*;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/20 17:30
 */
public class Test1Filter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		return null;
	}
}
