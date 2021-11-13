package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/13 14:28
 * @description 剑指 Offer II 021.删除链表的倒数第 n 个结点
 * 
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 进阶：能尝试使用一趟扫描实现吗？
 *
 * 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/SLwz0R
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question021 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;

        int i = 0;
        while (fast != null) {
            fast = fast.next;
            // 如果 fast 指针走了 n+1 个节点了，则 slow 开始走
            if (i++ >= n) {
                // 等待 fast 指针走到末尾时，slow 指针走到了倒数 n+1 个节点的位置
                slow = slow.next;
            }
        }

        // 此时 slow 指针指向倒数第 n+1 个节点的位置，删除倒数第 n 个节点的位置
        slow.next = slow.next.next;

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
