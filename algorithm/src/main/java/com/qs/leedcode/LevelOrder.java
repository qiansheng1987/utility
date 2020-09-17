package com.qs.leedcode;

import com.qs.leedcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p></p>
 *
 *   1
 *  2 3
 * 4 5
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/2 13:43
 */
public class LevelOrder {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode();
		node1.setValue(3);


		TreeNode node2 = new TreeNode();
		node2.setValue(6);

		TreeNode node3 = new TreeNode();
		node3.setValue(9);

		TreeNode node4 = new TreeNode();
		node4.setValue(19);

		TreeNode node5 = new TreeNode();
		node5.setValue(90);

		node1.setLeft(node2);
		node1.setRight(node3);

		node2.setLeft(node4);
		node2.setRight(node5);
		List<List<Integer>> lists = levelOrder(node1);
		System.out.println(lists.toString());
		System.out.println(minDepth(node1));

		Queue<Integer> queue = new LinkedList<>();
		queue.poll();
	}

	public static int minDepth(TreeNode root) {
		// bfs。一层一层的遍历，直到有一个节点的左右孩子都是空就返回这个高度
		List<TreeNode> levelTreeNodeList = new ArrayList<>();
		levelTreeNodeList.add(root);
		int level = 0;
		while (levelTreeNodeList.size() != 0) {
			level++;
			List<TreeNode> treeNodeList = new ArrayList<>();
			for (TreeNode node : levelTreeNodeList) {
				if (node.getLeft() == null && node.getRight() == null) {
					return level;
				}
				if (node.getLeft() != null) treeNodeList.add(node.getLeft());
				if (node.getRight() != null) treeNodeList.add(node.getRight());
			}
			levelTreeNodeList = treeNodeList;
		}
		return level;
	}

	public static  List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<>();
		if (null == root) {
			return re;
		}

		List<TreeNode> levelTreeNodeList = new ArrayList<>();
		levelTreeNodeList.add(root);
		while (levelTreeNodeList.size() != 0) {
			List<TreeNode> nextTreeNodeList = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			for (TreeNode node : levelTreeNodeList) {
				list.add(node.getValue());
				if (node.getLeft() != null) {
					nextTreeNodeList.add(node.getLeft());
				}
				if (node.getRight() != null) {
					nextTreeNodeList.add(node.getRight());
				}
				levelTreeNodeList = nextTreeNodeList;
			}
			re.add(list);
		}
		return re;
	}
}
