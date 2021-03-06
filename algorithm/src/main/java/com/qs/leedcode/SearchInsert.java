package com.qs.leedcode;

/**
 //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/4 14:50
 */
public class SearchInsert {
	// 输入: [1,3,5,6], 5
	//输出: 2

	// 输入: [1,3,5,6], 4
	//输出: 2
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,6};
		System.out.println(searchInsert(nums, 0));
	}

	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int left = 0, right = n - 1, ans = n;
		while (left <= right) {
			int mid = ((right - left) >> 1) + left;
			if (target <= nums[mid]) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
}
