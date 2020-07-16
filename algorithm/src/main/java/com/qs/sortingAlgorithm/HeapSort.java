package com.qs.sortingAlgorithm;

import java.util.Arrays;

/**
 * 功能描述 <p> 堆排序</p>
 *  分为维护堆和建堆
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/15 15:48
 */
public class HeapSort {

	public HeapSort() {
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,7,3, 2,2,3, 0,10};
		HeapSort sort = new HeapSort();
		sort.heapSort(arr, 9);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 维护堆的性质
	 * @param arr 存储堆的数组
	 * @param n 数组长度
	 * @param i 待维护节点的下标
	 */
	void heapify(int[] arr, int n, int i) {
		int largest = i;
		// 左孩子节点的下标
		int lson = i * 2 + 1;
		// 右孩子节点的下标
		int rson = i * 2 + 2;
		// 与左右节点比较，获取最大节点。
		if (lson < n && arr[largest] < arr[lson]) {
			largest = lson;
		}
		if (rson < n && arr[largest] < arr[rson]) {
			largest = rson;
		}
		if (largest != i) {
			swap(arr, largest, i);
			// 迭代维护堆
			heapify(arr, n, largest);
		}
	}

	/**
	 * 堆排序入口
	 * @param arr 待排数组
	 * @param n 数组大小
	 */
	private void heapSort(int[] arr, int n) {
		// 建堆
		for (int i = n/2 - 1 ; i>=0 ; i--) {
			heapify(arr, n, i);
		}
		//排序
		for (int i = n-1; i > 0 ; i--) {
			// 堆顶和最后一个元素交换
			swap(arr, i, 0);
			// 重新建堆
			heapify(arr, i, 0);
		}
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}
