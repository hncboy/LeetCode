package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/15 10:32
 * @description 5283.二进制链表转整数
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 *
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ConvertBinaryNumberInALinkedListToInteger c = new ConvertBinaryNumberInALinkedListToInteger();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(c.getDecimalValue(head));
    }

    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        int result = 0;
        int count = 1;
        while (head != null) {
            if (head.val == 1) {
                result += count;
            }
            count <<= 1;
            head = head.next;
        }
        return result;
    }

    /**
     * 链表反转
     *
     * @param head
     * @return
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
