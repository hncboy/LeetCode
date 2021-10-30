package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/10/30 11:45
 * @description 剑指 Offer II 023.两个链表的第一个重合节点
 *
 * 注意：本题与主站 160 题 {@link com.hncboy.IntersectionOfTwoLinkedLists }
 * 相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3u1WK4
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question023 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
