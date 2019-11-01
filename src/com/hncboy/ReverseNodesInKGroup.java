package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/1 9:51
 * @description 25.K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ReverseNodesInKGroup r = new ReverseNodesInKGroup();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(r.reverseKGroup(node, 3));
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(-1);
        node.next = head;
        // 反转链表区间的开始位置
        ListNode start = node;
        // 反转链表区间的结束位置
        ListNode end = node;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            // 需要反转的链表区间
            ListNode left = start.next;
            ListNode right = end.next;
            end.next = null;
            start.next = reverse(left);
            left.next = right;
            start = left;
            end = start;
        }

        return node.next;
    }

    /**
     * 反转链表
     *
     * @param node
     */
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
