package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/1 14:34
 * @description 83.删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(2);
        node2.next.next.next = new ListNode(3);
        node2.next.next.next.next = new ListNode(3);

        System.out.println(r.deleteDuplicates(node1));
        System.out.println(r.deleteDuplicates(node2));
    }

    private ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
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
