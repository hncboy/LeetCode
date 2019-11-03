package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/3 16:34
 * @description 109.有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
        ListNode node = new ListNode(-10);
        node.next = new ListNode(-3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        node.next.next.next.next = new ListNode(9);
        System.out.println(c.sortedListToBST(node));
    }

    private TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // 将链表节点都存入集合
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return groupTree(list, 0, list.size() - 1);
    }

    private TreeNode groupTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(list.get(start));
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = groupTree(list, start, mid - 1);
        node.right = groupTree(list, mid + 1, end);
        return node;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
