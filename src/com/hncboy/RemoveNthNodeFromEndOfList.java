package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/19 7:32
 * @description 19.删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(node, 5));
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        // first 节点先移动 n+1 个节点
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // 删除第一个节点
        if (first == null) {
            return head.next;
        }

        // second 节点移动到倒数 n+1 个节点的位置
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        // 删除最后一个节点
        if (n == 1) {
            second.next = null;
        } else {
            second.next = second.next.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
