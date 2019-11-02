package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/2 13:49
 * @description 92.反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseLinkedListII().reverseBetween(node, 2, 4));
    }

    private ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        /*
         将该链表分为三部分：
         第一部分：开始反转链表之前的链表
         第二部分：反转链表的部分
         第三部分：反转链表后开始的链表
         */

        // 存放第一部分
        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        // 存放第二部分为反转前的第一个节点，也就是反转后的最后一个节点
        ListNode after = null;

        // 存放第二部分的头节点
        ListNode prev = null;
        // 存放第三部分的第一个节点
        ListNode curr = head;

        for (int i = 1; i <= n; i++) {
            if (i < m) {
                before.next = curr;
                before = before.next;
                curr = curr.next;
                continue;
            }
            // 存放第二部分反转的最后一个节点
            if (i == m) {
                after = curr;
            }
            // 反转链表
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 拼接三部分
        // 第二部分+第三部分
        after.next = curr;
        // 第一部分+第二部分
        before.next = prev;

        return beforeHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
