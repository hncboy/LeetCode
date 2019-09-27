package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/27 8:53
 * @description 148.排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(0);
        System.out.println(new SortList().sortList2(node));
    }

    /**
     * 递归归并排序
     *
     * @param head
     * @return
     */
    private ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }

        return divideList(head, length);
    }

    /**
     * 拆分链表
     *
     * @param head
     * @param length
     * @return
     */
    private ListNode divideList(ListNode head, int length) {
        // 结束递归
        if (length <= 1) {
            return head;
        }

        // 将链表分成两部分
        // 左半部分链表
        ListNode leftEnd = head;
        for (int i = 0; i < length / 2 - 1; i++) {
            leftEnd = leftEnd.next;
        }
        // 右半部分链表
        ListNode rightStart = leftEnd.next;
        // 断开两半部分链表的连接
        leftEnd.next = null;

        return merge(divideList(head, length / 2), divideList(rightStart, length - length / 2));
    }

    /**
     * 排序两部分链表
     *
     * @param head1 前半部分链表
     * @param head2 后半部分链表
     * @return
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        // 为 null 表示已经合并完的，返回未合并的链表头
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // 更小的节点在前面
        ListNode head;
        if (head1.val < head2.val) {
            // head1 在前面，将 head1 的下一个节点与 head2 节点比较
            head = head1;
            head.next = merge(head1.next, head2);
        } else {
            // head2 在前面，将 head2 的下一个节点与 head1 节点比较
            head = head2;
            head.next = merge(head1, head2.next);
        }
        return head;
    }

    /**
     * 冒泡排序
     *
     * @param head
     * @return
     */
    private ListNode sortList1(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            for (ListNode q = p.next; q != null; q = q.next) {
                if (p.val > q.val) {
                    p.val = p.val ^ q.val;
                    q.val = p.val ^ q.val;
                    p.val = p.val ^ q.val;
                }
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
