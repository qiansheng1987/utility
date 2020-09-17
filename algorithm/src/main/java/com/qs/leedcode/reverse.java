package com.qs.leedcode;

/**
 * <p>整数反转</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/31 16:11
 */
public class reverse {

	public static void main(String[] args) {
		reverse(1234);
	}

	private static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int temp = x % 10;
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
				return 0;
			}
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
				return 0;
			}
			res = res * 10 + temp;
			x /= 10;
		}
		return res;
	}

}
