package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/2 10:21
 * @description 86.分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，
 * 使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);

        System.out.println(new PartitionList().partition(node, 3));
    }

    private ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode highHead = new ListNode(-1);
        // 存放比 x 大的节点的链表
        ListNode high = highHead;

        ListNode lowHead = new ListNode(-1);
        // 存放比 x 小的节点的链表
        ListNode low = lowHead;


        while (head != null) {
            if (head.val >= x) {
                high.next = head;
                high = high.next;
            } else {
                low.next = head;
                low = low.next;
            }
            head = head.next;
        }

        // 拼接 low 和 high 链表
        high.next = null;
        low.next = highHead.next;

        return lowHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
