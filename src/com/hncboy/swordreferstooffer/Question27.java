package com.hncboy.swordreferstooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2020/3/1 21:04
 * @description 面试题27.二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 */
public class Question27 {

    /**
     * BFS
     *
     * @param root
     * @return
     */
    private TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 从队列中取出节点并交换左右子树
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 交换左右子树
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        // 将左子树中的节点递归交换
        mirrorTree(root.left);
        //将右子树中的节点递归交换
        mirrorTree(root.right);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
