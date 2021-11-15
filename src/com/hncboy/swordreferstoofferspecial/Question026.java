package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/15 9:18
 * @description 剑指 Offer II 026.重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 输入: head = [1,2,3,4]
 * 输出: [1,4,2,3]
 *
 * 示例 2:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 *
 * 提示：
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 *
 * 注意：本题与主站 143 题 {@link com.hncboy.ReorderList} 相同：https://leetcode-cn.com/problems/reorder-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/LGjMqU
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question026 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 获取链表中间节点
        ListNode midNode = middleNode(head);
        ListNode before = head;

        // 将后面一半链表反转存放在 after 中
        ListNode after = reverse(midNode.next);
        // before 存放前一半链表
        midNode.next = null;

        // 合并两个链表
        mergeList(before, after);
    }

    /**
     * 开始重新排序，将前面一半和后面一半链表拼接
     */
    public void mergeList(ListNode before, ListNode after) {
        // 开始重新排序，将前面一半和后面一半链表拼接
        while (before != null && after != null) {
            ListNode beforeTemp = before.next;
            ListNode afterTemp = after.next;

            // before 节点的下一个节点是 after 节点
            before.next = after;
            // before 节点往下移动
            before = beforeTemp;

            // after 节点的下一个节点是 before.next 节点
            after.next = before;
            after = afterTemp;
        }
    }

    /**
     * 通过快慢指针找到链表的中间节点
     */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
