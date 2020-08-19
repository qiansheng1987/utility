package com.qiansheng.javaaqs.jvm;

/**
 * <p>gc分析</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1413:31
 */
public class YoungGcTest {

	public static void main(String[] args) {
		// 1MB
		byte[] array = new byte[2*1024 * 1204];
		array = new byte[2* 1024 * 1204];
		array = new byte[2* 1024 * 1204];
		array = new byte[128 * 1024];
		array = null;
		// 2MB
		array = new byte[2 * 1024 * 1204];
	}
}
