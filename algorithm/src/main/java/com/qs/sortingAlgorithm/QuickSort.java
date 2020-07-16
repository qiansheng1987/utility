package com.qs.sortingAlgorithm;

import java.util.Arrays;

/**
 * 功能描述 <p>快速排序</p>
 * <li>
 *    原理：
 *    快速排序是目前非常高效的一种排序算法，它不是稳定的排序算法，平均时间复杂度伟O（nlogn）
 *    最差的复杂度为O(n^2),基本思想是：通过一趟排序将要排序的数据分割成两部分，其中一部分的所有数据都比列外一分部的所有
 *    数据都要小，然后再按照此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据编程有序。
 *
 * 	归并排序也是基于分治的思想，不过归并流程是将子集合合并成为有序的集合，递归执行来完成整个集合的排序。
 * 	快速排序的分治流程是根据选定元素，将集合分隔为两个子集合，一个子集合中所有元素不大于选定元素值，
 * 	另一个子集合中所有元素不小于选定元素值，则用于拆分集合的选定元素即为已排序元素。
 * 	即每次拆分都会形成一个已排序元素，所以 N 个元素的序列，拆分的次数级别为O(N) 。将拆分过程类比为二叉树形式，
 * 	考虑普通二叉树和斜树的情况，则二叉树高度级别为 log2N~O(N)。

 * </li>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/14 14:09
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,7,3, 2,2,3, 0,10};
		System.out.println(Arrays.toString(sort(arr, 0, arr.length - 1)));
	}

	private static int[] sort(int arr[], int left, int right) {
		if (left < right) {
			int i = left, j = right;
			// 基准值
			int target = arr[left];
			while (i < j) {
				// 从右向左移动j，找到第一个小于基准值的值 arr[j]
				while (i<j && arr[j] > target) {
					j--;
				}
				// 将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针向中间移动一个位置i++
				if (i < j) {
					arr[i++] = arr[j];
				}
				// 从左右移动i，找到第一个大于基准值的值 arr[i]
				while (i < j && arr[i] < target) {
					i++;
				}
				// 将左侧找到的大于等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
				if (i < j) {
					arr[j] = arr[i];
					j--;
				}
			}
			arr[i] = target;
			sort(arr, left, i - 1);
			sort(arr, i + 1, right);
		}
		return arr;












	}
}
