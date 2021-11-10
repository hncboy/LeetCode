package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/10 10:25
 * @description 剑指 Offer II 027.回文链表
 *
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 *
 * 示例 2：
 * 输入: head = [1,2]
 * 输出: false
 *
 * 提示：
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 *  
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 注意：本题与主站 234 题 {@link com.hncboy.PalindromeLinkedList}
 * 相同：https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/aMhZSa
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question027 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        // 反转后半部分链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * 反转从链表中间节点到尾节点的节点
     *
     * @param head 头节点
     * @return 反转后的链表节点
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 通过快慢指针获取链表中间的节点，也就是前半部分链表的尾节点
     *
     * @param head 头指针
     * @return 中间指针
     */
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
