package com.qs.leedcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.comz
 * @date 2020/8/25 16:27
 */
public class Client {

	public static void main(String[] args) {
		// 中序遍历
		TreeNode node1 = new TreeNode(1, null, null);
		TreeNode node2 = new TreeNode(2, null, null);
		TreeNode node3 = new TreeNode(3, null, null);

		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node7 = new TreeNode(7, null, null);

		node2.setLeft(node1);
		node2.setRight(node3);

		node4.setLeft(node2);
		node4.setRight(node6);

		node6.setLeft(node5);
		node6.setRight(node7);

		//inOrder(node4);
		Stream.of(inorderTraversal(node4)).forEach(System.out::println);

	}

	private static void inOrder(TreeNode node) {
		if (null == node) {
			return;
		}
		inOrder(node.getLeft());
		System.out.println(node.getValue());
		inOrder(node.getRight());
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while ( stack.size() > 0 || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				TreeNode treeNode = stack.pop();
				res.add(treeNode.getValue());
				root = treeNode.getRight();
			}
		}
		return res;
	}
}
