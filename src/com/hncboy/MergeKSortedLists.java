package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/10 17:24
 * @description 23.合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        MergeKSortedLists m = new MergeKSortedLists();
        System.out.println(m.mergeKLists1(lists));
        System.out.println(m.mergeKLists2(lists));
    }

    /**
     * 归并分治
     *
     * @param lists
     * @return
     */
    private ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length - 1);
    }

    /**
     * 将数组中的链表两两分开合并
     *
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode solve(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) >> 1;
        ListNode leftNode = solve(lists, left, mid);
        ListNode rightNode = solve(lists, mid + 1, right);
        return merge(leftNode, rightNode);
    }

    /**
     * 两两排序合并链表
     *
     * @param node1
     * @param node2
     * @return
     */
    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }

    private ListNode mergeKLists1(ListNode[] lists) {
        ListNode node = new ListNode(-1);
        mergeKLists1(lists, node);
        return node.next;
    }

    private ListNode mergeKLists1(ListNode[] lists, ListNode node) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int count = 0;
        // 遍历每个节点，找出最小的值连接在 node 上
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                count++;
                continue;
            }
            if (lists[i].val <= min) {
                node.next = lists[i];
                minIndex = i;
                min = lists[i].val;
            }
        }
        if (minIndex != -1) {
            lists[minIndex] = lists[minIndex].next;
        }
        if (count == lists.length) {
            return node;
        }
        return mergeKLists1(lists, node.next);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
