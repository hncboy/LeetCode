package com.hncboy;

/**
 * @author hncboy
 * @date 2019/9/11 7:39
 * @description 124.二叉树中的最大路径和
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * <p>
 *       1
 *      / \
 *     2   3
 * <p>
 * 输出: 6
 * <p>
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 */
public class BinaryTreeMaximumPathSum {

    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(maxPathSum(node));
    }

    private static int maxPathSum(TreeNode root) {
        getMax(root);
        return result;
    }

    private static int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 子树路径和为负的话将该子树的值置为 0，表示不包含该子树
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        // 取当该节点包含左右子树的路径和当前的最大路径中的最大值
        result = Math.max(result, root.val + left + right);
        // 根节点 + 左右子树中最大的节点
        return Math.max(left, right) + root.val;
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
