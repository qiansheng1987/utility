package provider;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>本地注册中心</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/18 14:27
 */
public class LocalRegister {

	private static Map<String, Class> map = new HashMap<>();

	public static void regist(String interfaceName, Class implClass) {
		map.put(interfaceName, implClass);
	}

	public static Class get(String intefaceName) {
		return map.get(intefaceName);
	}

}





















