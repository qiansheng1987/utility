package com.qs.leedcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/717:01
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = new int[] {3,2,4};
		int target = 6;
		//int[] ints = twoSum(nums, target);
		int[] ints = twoSum2(nums, target);
		Arrays.stream(ints).forEach(System.out::println);
	}

	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i< nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] temp = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++){
				if (nums[i] + nums[j] == target) {
					temp[0] = nums[i];
					temp[1] = nums[j];
					return temp;
				}
			}
		}
		return temp;
	}
}
