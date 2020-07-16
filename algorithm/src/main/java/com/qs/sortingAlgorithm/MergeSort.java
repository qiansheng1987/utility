package com.qs.sortingAlgorithm;

import java.util.Arrays;

/**
 * 功能描述 <p> 归并排序 先拆分在归并
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/15 14:08
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,7,3, 2,2,3, 0,10};
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	private static int[] mergeSort(int[] arr) {
		return sort(arr, 0, arr.length - 1);
	}

	private static int[] sort(int[] arr, int left, int right) {
		if (left >= right) {
			return arr;
		}
		// 找出中间索引
		int center = (left + right) >> 1;
		// 对左边数组进行递归
		sort(arr, left, center);
		// 对右边数组进行递归
		sort(arr, center + 1, right);
		return merge(arr, left, center, right);
	}

	/**
	 * 将两个数组进行归并，归并钱2个数组已经有序，归并后依然有序
	 * @param arr 数组对象
	 * @param left 左边数组的第一个元素索引
	 * @param center 左边数组的最后一个元素索引， center+1是右边数组第一个元素的索引
	 * @param right 右边数组的最后一个元素的索引
	 * @return 排序后数组
	 */
	private static int[] merge(int[] arr, int left, int center, int right) {

		// 临时数组，用于临时保存归并的结果
		int[] tempArr = new int[arr.length];
		// 右边数组的第一个元素索引
		int mid = center + 1;
		// 记录临时数组应该插入元素位置的索引
		int third = left;
		// 缓存左数组第一个元素的索引
		int tmp = left;

		while (left <= center && mid <= right) {
			// 从两边数组中选择较小的数放入临时数组中
			if (arr[left] <= arr[mid]) {
				tempArr[third++] = arr[left++];
			} else {
				tempArr[third++] = arr[mid++];
			}
		}
		// 将剩余部分放入数组，（实际两个while只会执行一个）
		while (mid <= right) {
			tempArr[third++] = arr[mid++];
		}
		while (left <= center) {
			tempArr[third++] = arr[left++];
		}
		// 将临时数组中的内容拷贝回原数组中
		//（原 left-right 范围的内容被复制回原数组）
		while (tmp <= right) {
			arr[tmp] = tempArr[tmp++];
		}
		return arr;
	}


}
