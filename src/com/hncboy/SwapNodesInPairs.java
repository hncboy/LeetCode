package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/3 9:02
 * @description 24.两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(new SwapNodesInPairs().swapPairs2(node));
    }

    /**
     * 非递归
     *
     * @param head
     * @return
     */
    private ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode p = node;
        while (p.next != null && p.next.next != null) {
            ListNode start = p.next;
            ListNode end = p.next.next;
            p.next = end;
            start.next = end.next;
            end.next = start;
            p = start;
        }
        return node.next;
    }

    /**
     * 递归
     * 超出内存限制
     *
     * @param head
     * @return
     */
    private ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(head.next);
        next.next = head;
        return next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
