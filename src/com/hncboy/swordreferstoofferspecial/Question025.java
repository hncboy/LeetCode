package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/15 9:04
 * @description 剑指 Offer II 025.链表中的两数相加
 * 
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
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
 *
 * 提示：
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 * 注意：本题与主站 445 题 {@link com.hncboy.AddTwoNumbersII}
 * 相同：https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lMSNwu
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question025 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
