package com.qs.leedcode;

/**
 * <p>回文数</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/31 16:47
 */
public class isPalindrome {

	public static void main(String[] args) {
		//		String input = String.valueOf(x);=
		boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(5/2);
		System.out.println(6/2);
		System.out.println(palindrome);
	}

	private static boolean isPalindrome2(String str) {
		if (str.length() == 0) {
			return true;
		}
		StringBuilder builder = new StringBuilder();
		for (char c : str.toCharArray()) {
			boolean letterOrDigit = Character.isLetterOrDigit(c);
			if (letterOrDigit) {
				builder.append(Character.toLowerCase(c));
			}
		}
		char[] chars = builder.toString().toCharArray();
		// abc abccba

		return false;
	}

	// 123321
	private static boolean isPalindrome(String str) {
		StringBuilder builder = new StringBuilder();
		for (char c : str.toCharArray()) {
			boolean letterOrDigit = Character.isLetterOrDigit(c);
			if (letterOrDigit) {
				builder.append(Character.toLowerCase(c));
			}
		}
		char[] chars = builder.toString().toCharArray();
		int left = 0;
		int right = chars.length - 1;
		boolean re = true;
		while (left < right) {
			if (chars[left] == chars[right]) {
				left++;
				right--;
			} else {
				re = false;
				break;
			}
		}
		return re;
	}
}
