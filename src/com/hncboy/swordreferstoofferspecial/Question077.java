package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/8 14:29
 * 剑指 Offer II 077.链表排序
 *
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *  
 * 提示：
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 注意：本题与主站 148 题 {@link com.hncboy.SortList} 相同：https://leetcode-cn.com/problems/sort-list/
 * 通过次数 7,546 提交次数 12,837
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/7WHec2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question077 {

    public ListNode sortList(ListNode head) {
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2.找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        // 3.将左部分和右部分节点进行排序并合并有序链表
        return merge(sortList(head), sortList(rightHead));
    }

    /**
     * 找到链表中间节点
     */
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }

            curr = curr.next;
        }

        curr.next = head1 != null ? head1 : head2;
        return dummy.next;
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
