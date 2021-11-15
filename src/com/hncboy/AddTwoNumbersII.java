package com.hncboy;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/4 11:50
 * @description 445.两数相加 II
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 * 示例2：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 *
 * 示例3：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *  
 * 提示：
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbersII {

    public static void main(String[] args) {
        AddTwoNumbersII a = new AddTwoNumbersII();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        System.out.println(a.addTwoNumbers2(node1, node2));
    }

    private ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);

        // 当前节点
        ListNode curr = null;
        // 上一个节点
        ListNode prev;

        int num = 0;
        while (reverse1 != null || reverse2 != null) {
            if (reverse1 != null) {
                num += reverse1.val;
                reverse1 = reverse1.next;
            }
            if (reverse2 != null) {
                num += reverse2.val;
                reverse2 = reverse2.next;
            }

            // 当前节点拼接上一个节点
            prev = curr;
            curr = new ListNode(num % 10);
            curr.next = prev;
            num /= 10;
        }

        // 如果有进位
        if (num == 1) {
            prev = curr;
            curr = new ListNode(1);
            curr.next = prev;
        }
        return curr;
    }

    /**
     * 反转链表
     */
    private ListNode reverse(ListNode head) {
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

    private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        // 将两个链表的值存入两个栈中
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.add(l2.val);
                l2 = l2.next;
            }
        }

        // 将两个栈中的值出栈相加存入第三个栈中
        int num = 0;
        Stack<Integer> s3 = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                num += s1.pop();
            }
            if (!s2.isEmpty()) {
                num += s2.pop();
            }
            s3.add(num % 10);
            num /= 10;
        }

        // 第一位相加大于 10 的情况
        if (num > 0) {
            s3.add(num);
        }

        // 将第三个栈中的值依次插入链表
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (!s3.isEmpty()) {
            node.next = new ListNode(s3.pop());
            node = node.next;
        }

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
