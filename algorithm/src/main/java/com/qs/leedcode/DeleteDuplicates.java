package com.qs.leedcode;

/**
 * <p>给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/4 17:19
 */
public class DeleteDuplicates {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
        // 1->2->3
		ListNode listNode = deleteDuplicates(node1);
		ListNode current = listNode;
		while (current != null && current.next != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

	public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

	public static ListNode deleteDuplicates(ListNode head) {
		// 输入: 1->1->2->3->3
		//输出: 1->2->3
		ListNode current = head;
		while (null != current && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}
