package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/25 11:09
 * @description 203.移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next.next = new ListNode(6);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(1);
        node2.next.next = new ListNode(2);
        System.out.println(new RemoveLinkedListElements().removeElements3(node1, 6));
    }

    /**
     * 递归删除节点
     *
     * @param head
     * @param val
     * @return
     */
    private ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 添加一个头节点
     *
     * @param head
     * @param val
     * @return
     */
    private ListNode removeElements2(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode current = node;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return node.next;
    }

    /**
     * 单独考虑头节点的删除
     *
     * @param head
     * @param val
     * @return
     */
    private ListNode removeElements1(ListNode head, int val) {
        // 删除头节点的值与 val 相同的节点
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
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

