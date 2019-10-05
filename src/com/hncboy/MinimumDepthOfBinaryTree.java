package com.hncboy;

/**
 * @author hncboy
 * @date 2019/10/5 10:56
 * @description 111.二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(new MinimumDepthOfBinaryTree().minDepth(node));
    }

    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左节点为 null，右节点不为 null，往右子树继续遍历
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // 左节点不为 null，右节点为 null，往左子树继续遍历
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        // 当左右节点都不为 null 时，返回深度最小的
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
