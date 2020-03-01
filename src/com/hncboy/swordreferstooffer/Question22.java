package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/3/1 19:35
 * @description 面试题22.链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class Question22 {

    public static void main(String[] args) {
        Question22 q = new Question22();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(q.getKthFromEnd(head, 1));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        // p 指针先走 k 步
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        // p 指针一直走到底，这时 p 指针走的步数为 total-k
        // q 指针从头开始走，也走了 total-k 步
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
