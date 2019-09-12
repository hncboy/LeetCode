package com.hncboy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/9/12 18:23
 * @description 144.二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePreorderTraversal {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(preorderTraversal2(node));
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversal1(TreeNode root) {
        addNode(root);
        return list;
    }

    private static void addNode(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        addNode(root.left);
        addNode(root.right);
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
