package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/14 13:42
 * @description 剑指 Offer II 024.反转链表
 *
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 注意：本题与主站 206 题 {@link com.hncboy.ReverseLinkedList}
 * 相同： https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UHnkqh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question024 {

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 存储当前节点的下一个节点
            ListNode nextTemp = curr.next;
            // 当前节点的下一个节点指向前面的节点，逆序
            curr.next = prev;
            // 前节点指向当前节点，前节点后移
            prev = curr;
            // 当前节点后移
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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
