package com.qs.sortingAlgorithm;

import java.util.Arrays;

/**
 * 功能描述 <p>选择排序
 *
 * <li>
 *     选择排序与上一章的 冒泡排序 很相似，两者都维护了待排序集合和已排序集合，
 *     每次迭代结束都会产生一个已排序元素。不同之处在于冒泡排序的极值元素是通过不断的比较和交换位置产生的，
 *     选择排序则是不断比较和一次交换位置产生，所以相对冒泡排序，性能上具有优势。
 *
 *     以递增排序为例，初始集合即为待排序集合，已排序集合初始为空,算法过程如下：
 * 1. 声明变量index并指定初始值为待排序集合第一个元素的下标，通过遍历待排序集合，比较并更新index ，
 * 		若index指向不为待排序集合最后一个元素，则交换index指向的值和待排序集合最后一个元素；
 * 2. 标记待排序集合最后一个元素为已排序；
 * 3. 重复步骤 1,2，直到待排序集合只有一个元素
 *
 * 先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * </li>
 * @author sheng.qian01@ucarinc.com
 * @date 2020/7/14 10:48
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 6, 2, 4, 0, 10, 13, 4, 2};
		System.out.println(Arrays.toString(sort(arr)));
	}

	private static int[] sort(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length ; i++) {
			// 标记最小元素的索引
			int index = i;
			for (int j = i + 1; j < length ; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			// 如果index！=i则表示当前最小元素已近不是i所标识的位置
			if (index != i) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		return arr;
	}
}
