package com.qs.dynamicProgram;

/**
 * <p>动态规划
 *
 * 动态规划算法与分治法类似,其基本思想也是将待求解问题分解成若干个子问题,先求解子问题,然后从这些子问题的解得到原问题的解。
 * 与分治法不同的是,适合于用动态规划求解的问题,经分解得到子问题往往不是互相独立的。若用分治法来解这类问题,则分解得到的子问题数目太多,
 * 有些子问题被重复计算了很多次。如果我们能够保存已解决的子问题的答案,而在需要时再找出已求得的答案,这样就可以避免大量的重复计算,
 * 节省时间。我们可以用一个表来记录所有已解的子问题的答案。不管该子问题以后是否被用到,只要它被计算过,就将其结果填入表中。
 * 这就是动态规划法的基本思路
 *
 *
 * https://blog.csdn.net/u013309870/article/details/75193592?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.add_param_isCf&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.add_param_isCf
 * </p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/27 16:07
 */
public class Dynamic {

	public static void main(String[] args) {
		// 0 1 1 2 3 5
		System.out.println(fib(5));
	}

	/**
	 * 自底向上的动态规划
	 * 核心：先计算自问题，然后由子问题再计算父问题
	 */

	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int[] memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < memo.length; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	/**
	 * 采用递归
	 */
	public static int fib1(int n ) {
		return n <=1 ? n : (fib1(n-1) + fib1(n - 2));
	}

}
