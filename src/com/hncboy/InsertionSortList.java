package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/3 15:08
 * @description 147.对链表进行插入排序
 */
public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList i = new InsertionSortList();
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(-1);
        node2.next = new ListNode(5);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        node2.next.next.next.next = new ListNode(0);

        System.out.println(i.insertionSortList(node1));
        System.out.println(i.insertionSortList(node2));
    }

    private ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while(head != null){
            ListNode curr = newHead;
            ListNode next = head.next;
            while(curr.next != null && curr.next.val < head.val){
                curr = curr.next;
            }
            // head 为当前需要插入的节点，插入在 curr 节点后
            head.next = curr.next;
            // curr 节点后一个节点指向 head
            curr.next = head;
            // head 指向下一个节点
            head = next;
        }
        return newHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
