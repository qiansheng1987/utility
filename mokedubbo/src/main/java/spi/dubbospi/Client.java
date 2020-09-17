package spi.dubbospi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * <p></p>
 * -Xms4096M -Xmx4096M -Xmn3072M -Xss1M  -XX:PermSize=256M -XX:MaxPermSize=256M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFaction=92
 * -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0
 * 堆 xms初始堆，xmx最大堆，
 * xmn 年轻代
 * xss每个线程堆栈的大小1M
 *
 * 堆分为  新生代（eden + from + to 8:1:1） + 老年代 + 永久代（方法区）
 *
 * youngGc时机
 * 新生代满了触发minor gc
 * fullgc时机
 * 1.对象在新生代躲过了15次的minorgc 就会转移到老年代中
 * 2.大对象直接进入老年代
 * 3.根据动态年龄规则判断。如果各个对象的年龄1，2..n的大小总共超过了survive区域的50%则把年龄超过n的都直接放入老年代
 * 4. 如果还minorgc后发现eden存活的对象太多，无法放入survive则直接放入老年代。
 *
 * #### 几个触发老年代GC的时机
 *
 * **第一**是老年代可用内存小于新生代全部对象的大小，如果没**开启空间担保参数**，会直接触发Full GC，所以一般空间担保参数都会打开；
 *
 * **第二**是老年代可用内存小于历次新生代GC后进入老年代的平均对象大小，此时会提前Full GC；
 *
 * **第三**是新生代Minor GC后的存活对象大于Survivor，那么就会进入老年代，此时老年代内存不足。
 *
 * 上述情况都会导致老年代Full GC。
 *
 * 今天加了一个触发时机，就是“-XX:CMSInitiatingOccupancyFaction”参数
 *
 * 刨除掉上述几种情况，如果老年代可用内存大于历次新生代GC后进入老年代的对象平均大小，但是老年代已经使用的内存空间超过了这个参数指定的比例，也会自动触发Full GC。
 *
 *
 *
 * select *
 * where查询 不要对字段进行函数运行，
 * 防止字段类型不一致导致的索引失效，比如字段是varchar类型，但是查询条件 为a= 1没有加单引号
 * 复合索引，要注意坐匹配原则
 * 避免对字段进行空判断。
 * 建索引的时候，尽量对有区分度的字段加索引。
 *
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/19 9:47
 */
public class Client {

	public static void main(String[] args) {
		ExtensionLoader<MessageService> extensionLoader = ExtensionLoader.getExtensionLoader(MessageService.class);

		/*MessageService email = extensionLoader.getExtension("email");
		email.sendMsg("dubbo spi email send msg");
		MessageService sms = extensionLoader.getExtension("sms");
		sms.sendMsg("dubbo spi sms send");*/

		URL url = URL.valueOf("dubbo://localhost/dubbo?messageKey=sms");
		MessageService adaptiveExtension = extensionLoader.getAdaptiveExtension();
		extensionLoader.getExtension("email");
		extensionLoader.getDefaultExtension();
		adaptiveExtension.sendMsg(url,"qiansheng");
	}
}
















