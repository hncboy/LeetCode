package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/25 12:26
 * @description 61.旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        System.out.println(new RotateList().rotateRight2(node1, 2));
    }

    /**
     * 将链表连接成环
     *
     * @param head
     * @param k
     * @return
     */
    private ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode oldTail = head;
        int count = 1;
        // 计算链表长度
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            count++;
        }
        // 将链表连接成环
        oldTail.next = head;

        // 移动 count - k % count - 1 个节点，寻找移动后的链表尾节点
        ListNode newTail = head;
        for (int i = 0; i < count - k % count - 1; i++) {
            newTail = newTail.next;
        }

        // 新的链表头节点为新尾节点的下一个
        ListNode newHead = newTail.next;
        // 关闭链表的环
        newTail.next = null;

        return newHead;
    }

    private ListNode rotateRight1(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 统计链表有多少个节点
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }

        // 移动 k 个位置
        k = k % count;
        // 如果链表只有一个节点或移动位置位 0，则返回原来链表
        if (count == 1 || k == 0) {
            return head;
        }

        p = head;
        // 链表第 count-k 个节点作为新的链表头节点，
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }

        // 将 q 节点移动到尾节点
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
        }

        // 将原来的头节点连接到 q 节点尾节点后
        for (int i = 0; i < count - k; i++) {
            q.next = head;
            q = q.next;
            head = head.next;
        }
        // 使得链表满足原来的长度
        q.next = null;
        return p;
    }
}
