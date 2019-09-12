package com.hncboy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/9/12 18:33
 * @description 145.二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePostorderTraversal {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(postorderTraversal2(node));
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            list.add(0, node.val);
        }
        return list;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal1(TreeNode root) {
        addNode(root);
        return list;
    }

    private static void addNode(TreeNode root) {
        if (root == null) {
            return;
        }
        addNode(root.left);
        addNode(root.right);
        list.add(root.val);
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
