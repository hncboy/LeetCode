package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/2 14:36
 * @description 143.重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList2(node);
    }

    private void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 通过快慢指针找到链表的中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将后面一半链表反转存放在 after 中
        ListNode after = reverse(slow.next);
        // before 存放前一半链表
        slow.next = null;
        ListNode before = head;

        // 将前面一半和后面一半链表拼接
        while (after != null) {
            ListNode node = new ListNode(after.val);
            node.next = before.next;
            before.next = node;
            before = before.next.next;
            after = after.next;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode p = head;
        // 将链表节点存入 ArrayList
        List<ListNode> list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            // 头尾指针连接
            list.get(left++).next = list.get(right);
            // 偶数节点的情况
            if (left == right) {
                break;
            }
            // 尾头指针连接
            list.get(right--).next = list.get(left);
        }
        list.get(left).next = null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
