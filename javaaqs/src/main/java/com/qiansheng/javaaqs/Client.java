package com.qiansheng.javaaqs;

import java.util.Stack;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/24 13:52
 */
public class Client {
	// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
	public static void main(String[] args) {
		System.out.println(isValid("[]"));
	}


	public static boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '{') {
				stack.push('}');
				continue;
			} else if ( c == '[') {
				stack.push(']');
				continue;
			} else if (c == '(') {
				stack.push(')');
				continue;
			}
			if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
