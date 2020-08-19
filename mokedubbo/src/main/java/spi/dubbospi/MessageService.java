package spi.dubbospi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/19 9:43
 */

@SPI("email")
public interface MessageService {

	void sendMsg(String messageBody);
}
