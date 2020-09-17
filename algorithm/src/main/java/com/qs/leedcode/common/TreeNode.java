package com.qs.leedcode.common;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/25 16:09
 */
public class TreeNode {

	private int value;

	private TreeNode left, right;

	public TreeNode() {
	}

	public TreeNode(int value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
