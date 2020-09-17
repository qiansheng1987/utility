package com.qs.leedcode;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/2 16:57
 */
public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{4,4, 1, 2, 1, 2, 7,7,5}));
	}

	/**
	 * 按位异或的3个特点：
	 *
	 * 　　（1） 0^0=0，0^1=1 0异或任何数＝任何数
	 *
	 * 　　（2） 1^0=1，1^1=0 1异或任何数－任何数取反
	 *
	 * 　　（3） 任何数异或自己＝把自己置0
	 */
	public static int singleNumber(int[] nums) {
		int first = nums[0];
		for (int i = 1; i < nums.length; i++) {
			first ^= nums[i];
		}
		return first;
	}

}
