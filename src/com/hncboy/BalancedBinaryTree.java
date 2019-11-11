package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/11 13:23
 * @description 110.平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree b = new BalancedBinaryTree();
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.left.left = new TreeNode(3);
        node2.left.left.left = new TreeNode(4);
        node2.left.left.right = new TreeNode(4);
        node2.left.right = new TreeNode(4);
        node2.right = new TreeNode(2);

        //System.out.println(b.isBalanced2(node1));
        System.out.println(b.isBalanced2(node2));
    }

    /**
     * 从底至顶（提前阻断法）
     *
     * @param root
     * @return
     */
    private boolean isBalanced2(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        // 自底向上比较每个节点，当有个不平衡时就返回 -1
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    /**
     * 暴力法
     *
     * @param root
     * @return
     */
    private boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 该节点满足平衡且递归该节点进行判断
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced1(root.left)
                && isBalanced1(root.right);
    }

    /**
     * 获取该节点的最大深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
