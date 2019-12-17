package com.hncboy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hncboy
 * @date 2019/9/8 15:03
 * @description 141.形链表
 * <p>
 * 定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *  
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        System.out.println(hasCycle2(node));
    }

    private static boolean hasCycle2(ListNode head) {
        // 快慢指针，即采用两个指针 slow 和 fast
        // slow 移动一步 fast 移动两步 如果有环一定会相遇
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle1(ListNode head) {
        // 采用 Set 存储，不考虑空间复杂度
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
