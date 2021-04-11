package com.qs.leedcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>最小栈</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/1 10:18
 */
public class MinStack {

	public static void main(String[] args) {
		//// 测试用例:["MinStack","push","push","push","getMin","pop","getMin"] [[],[0],[1],[0],[],[],[]]
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
	}

	private Deque<Integer> stack;
	private Deque<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new ArrayDeque<Integer>();
		minStack = new ArrayDeque<Integer>();
	}

	public void push(int x) {
		stack.addFirst(x);
		if (minStack.isEmpty()) {
			minStack.addFirst(x);
		} else {
			int peek = minStack.getFirst();
			if (x <= peek) {
				minStack.addFirst(x);
			}
		}
	}


	public void pop() {
		int pop = stack.pop();
		int peek = minStack.getFirst();

		if (pop == peek) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.getFirst();
	}

	public int getMin() {
		return minStack.getFirst();
	}
}
