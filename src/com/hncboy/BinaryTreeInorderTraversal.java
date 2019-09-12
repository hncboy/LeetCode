package com.hncboy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/9/12 7:53
 * @description 94.二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class BinaryTreeInorderTraversal {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(inorderTraversal2(node));
    }
    private static List<Integer> inorderTraversal2(TreeNode root) {
        addNode(root);
        return list;
    }

    private static void addNode(TreeNode root) {
        if (root == null) {
            return;
        }
        addNode(root.left);
        list.add(root.val);
        addNode(root.right);
    }

    private static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
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
