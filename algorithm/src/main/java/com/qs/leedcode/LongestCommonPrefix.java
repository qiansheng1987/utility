package com.qs.leedcode;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/4 13:34
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		//["flower","flow","flight"]
		System.out.println(longestCommonPrefix(new String[]{"aac","acab","aa","abba","aa"}));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		// 计算所有字符中最短的长度
		int length = strs.length;
		String commonPrefix = strs[0];
		for (int i = 1; i< length; i++) {
			commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
			if (commonPrefix.length() == 0) {
				return "";
			}
		}
		return commonPrefix;

	}
	// ["flower","flow","flight"]
	public static String getCommonPrefix(String str1, String str2) {
		int minLength = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < minLength) {
			if (str1.charAt(index) == str2.charAt(index)) {
				index++;
			} else {
				break;
			}
		}
		return str1.substring(0, index);
	}
}
