package com.hncboy;

/**
 * @author hncboy
 * @date 2019/8/30 9:52
 * @description 445.两数相加 II
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {

    private static boolean flag = false; // 判断是否有多出来的 10
    private static ListNode head = null;
    private static ListNode tail = null;

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);*/
        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);*/
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (true) {
            if (l1 == null && l2 != null) {
                addNode(sumVal(l2.val));
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                addNode(sumVal(l1.val));
                l1 = l1.next;
            } else if (l1 != null) {
                addNode(sumVal(l1.val + l2.val));
                l1 = l1.next;
                l2 = l2.next;
            } else {
                // 如果最后两个数相加超过 10
                if (flag) {
                    addNode(1);
                }
                return head;
            }
        }
    }

    /**
     * 计算和
     *
     * @param val
     * @return
     */
    private static int sumVal(int val) {
        // 如果前面两位相加的数的和 > 10
        if (flag) {
            int sum = val + 1; // 后面一位数 + 1
            if (sum >= 10) {
                return sum % 10;
            }
            flag = false;
            return sum;
        } else {
            // 只有 l1.val + l2.val 这种情况才会和 > 10
            if (val >= 10) {
                flag = true;
                return val % 10;
            }
            return val;
        }
    }

    /**
     * 添加节点
     *
     * @param val
     */
    private static void addNode(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
