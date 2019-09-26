package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/26 8:36
 * @description 206.反转链表
 *
 * 转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseLinkedList().reverseList2(node));
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    private ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 存储当前节点的下一个节点
            ListNode nextTemp = curr.next;
            // 当前节点的下一个节点指向前面的节点，逆序
            curr.next = prev;
            // 前节点指向当前节点，前节点后移
            prev = curr;
            // 当前节点后移
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    private ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList2(head.next);
        // 两个节点构成循环，node 的下一个节点指向 head 上一个节点
        head.next.next = head;
        // 关闭循环
        head.next = null;
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
