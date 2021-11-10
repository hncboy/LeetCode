package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/27 8:27
 * @description 234.回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);

        System.out.println(new PalindromeLinkedList().isPalindrome(node));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 1.计算链表的长度
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }

        // 2.反转链表的前一半链表
        ListNode prev = null;
        // 反转后链表中间的节点
        ListNode curr = head;
        for (int i = 0; i < length / 2; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        System.out.println(curr);


        // 3.判断链表长度奇数还是偶数
        // 奇数的话多出一个不用比较的数
        if (length % 2 != 0) {
            // curr 节点后往移动
            curr = curr.next;
        }

        // 4.比较 prev 和 curr
        while (prev != null && curr != null) {
            if (prev.val != curr.val) {
                return false;
            }
            prev = prev.next;
            curr = curr.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
