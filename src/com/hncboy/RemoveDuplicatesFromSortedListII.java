package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/1 14:47
 * @description 82.删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(2);
        node2.next.next.next = new ListNode(3);
        node2.next.next.next.next = new ListNode(3);

        System.out.println(r.deleteDuplicates(node1));
        System.out.println(r.deleteDuplicates(node2));
    }

    private ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode p = node;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int num = p.next.val;
                while (p.next != null && p.next.val == num) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return node.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
