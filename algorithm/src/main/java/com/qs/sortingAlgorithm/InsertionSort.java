package com.qs.sortingAlgorithm;

import java.util.Arrays;

/**
 * 功能描述 <p>插入排序</p>
 * <li>
 *   原理：将数据分为两部分，有序部分和无序部分，一开始有序部分包含第一个元素，依次将无序的元素插入到有序部分，
 *   直到所有元素有序。插入排序又分为直接插入排序、二分插入排序，链表插入等，这里只讨论直接插入排序，它是稳定的排序算法
 *   时间复杂度伟O(n^2)
 * </li>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/14 11:26
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,7,3, 2,2,3, 0,10};
		System.out.println(Arrays.toString(sort(arr)));
	}

	private static int[] sort(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			// 有序集合的最大下标
			int j = i - 1;
			// 无序集合的第一个元素
			int k = arr[i];
			// 条件k<arr[j]为正序，k>arr[j]为倒序
			while (j > -1 && k < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = k;
		}
		return arr;
	}
}
