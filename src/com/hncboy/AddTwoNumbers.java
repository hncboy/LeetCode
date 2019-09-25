package com.hncboy;

/**
 * User: hncboy
 * DateTime: 2019/8/30 9:52
 * Description:
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
