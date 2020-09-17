package com.qs.leedcode;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/1 11:10
 */
public class IsValidBST {

	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
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

	public boolean isValidBST(TreeNode root) {
		if (null == root) {
			return false;
		}
		return true;
	}

	private boolean helper(TreeNode node, Integer lower, Integer upper) {

		int val = node.val;
		if (lower != null && val < lower) {
			return false;
		}
		if (upper != null && val > upper) {
			return false;
		}
		return true;
	}
}
