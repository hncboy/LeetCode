package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2020/3/1 20:16
 * @description 面试题24.反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Question24 {

    public static void main(String[] args) {
        Question24 q = new Question24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(q.reverseList(head));
    }
    
    /**
     * 方法 1
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        // node 为 head.next，node.next = head，反转
        head.next.next = head;
        // 移除 head 后面的节点
        head.next = null;
        return node;
    }

    /**
     * 方法 2
     *
     * @param head
     * @return
     */
    private ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

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
