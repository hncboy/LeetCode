package com.hncboy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/12/31 12:49
 * @description 1302.层数最深叶子节点的和
 *
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 * 示例：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * 提示：
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class DeepestLeavesSum {

    private int sum;
    private int maxDepth;

    public static void main(String[] args) {
        DeepestLeavesSum d = new DeepestLeavesSum();
        TreeNode node = d.new TreeNode(1);
        node.left = d.new TreeNode(2);
        node.left.left = d.new TreeNode(4);
        node.left.left.left = d.new TreeNode(7);
        node.left.right = d.new TreeNode(5);
        node.right = d.new TreeNode(3);
        node.right.right = d.new TreeNode(6);
        node.right.right.right = d.new TreeNode(8);
        System.out.println(d.deepestLeavesSum2(node));
    }

    private int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                sum = node.val;
                maxDepth = depth;
            } else if (depth == maxDepth) {
                sum += node.val;
            }
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private int deepestLeavesSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 统计这一层的节点数
        while (!queue.isEmpty()) {
            // 该层的节点数量
            int levelCount = queue.size();
            result = 0;
            // 遍历该层所有节点
            while (levelCount > 0) {
                TreeNode node = queue.poll();
                result += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                levelCount--;
            }
        }

        return result;
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
