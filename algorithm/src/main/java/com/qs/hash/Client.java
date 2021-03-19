package com.qs.hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/23 15:42
 */
public class Client<T> {

	private SortedMap<Integer, T> circle = new TreeMap();

	public Client(Collection<T> nodes) {
		for (T node : nodes) {
			addNode(node);
		}
	}

	private void addNode(T t) {
		if (null == t) {
			throw new IllegalArgumentException("无法参数");
		}
		int key = t.hashCode();
		circle.put(key, t);
	}

	private void delNode(T t) {
		if (t == null) {
			return;
		}
		int key = t.hashCode();
		circle.remove(key);
	}

	/**
	 * https://www.cnblogs.com/yanayo/p/javaHome.html
	 * 扩展性，容错性。影响范围小把keyhash到一个逻辑圆环上，可以的范围是0-2^23,
	 * 获取数据的逻辑的是，data 通过hash函数 得到的hash值，然后按找顺时针的方向找到第一个分散中环上的值，
	 * 分了避免数据
	 *
	 * https请求， 直接http+ssl/tsl  http 不对报文加密，
	 * https用对称加密算法对传输数据进行加密， 需要私钥，https使用非对称加密算法传输私密
	 * 客户端
	 * @param key
	 * @return
	 */
	private T getNode(Object key) {
		if (circle.size() == 0) {
			return null;
		}
		int hashKey = key.hashCode();
		if (circle.containsKey(key)) {
			return circle.get(hashKey);
		}
		SortedMap<Integer, T> integerTSortedMap = circle.tailMap(hashKey);
		Integer integer = integerTSortedMap.isEmpty() ? circle.firstKey() : integerTSortedMap.firstKey();
		return circle.get(integer);
	}
}
