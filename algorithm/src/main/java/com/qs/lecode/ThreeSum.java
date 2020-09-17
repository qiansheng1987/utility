package com.qs.lecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/25 10:35
 */
public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-2,0,0,2,2}));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return null;
		}
		Arrays.sort(nums);
		int length  = nums.length;
		List<List<Integer>> re = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			// 去重
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int left = i + 1;
			int right = length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> integers = Arrays.asList(nums[i], nums[left], nums[right]);
					re.add(integers);
					while ((left < right) && nums[left] == nums[left+1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right-1]) {
						right--;
					}
					left++;
					right--;
				} else if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				}
			}
		}
		return re;
	}
}
