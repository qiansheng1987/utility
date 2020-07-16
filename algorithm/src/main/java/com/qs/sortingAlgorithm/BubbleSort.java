package com.qs.sortingAlgorithm;

import java.util.Arrays;

/**
 * 功能描述 <p>冒泡排序</p>
 * <li>冒泡排序是一种通过交换元素位置实现的稳定排序方式，其特点是每一轮排序后，
 * 都会在首端或尾端产生一个已排序元素，就像水泡不断上浮一样，通过多次排序，最终所有元素变得有序。
 * </li>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/14 10:25
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,7,3, 2,2,3, 0,10};
		System.out.println(Arrays.toString(sort(arr)));
	}

	private static int[] sort(int[] arr) {
		int length = arr.length - 1;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				if (arr[j] < arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}
