package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/7 9:39
 * @description 783.二叉搜索树结点最小距离
 *
 * 定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 注意：
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 */
public class MinimumDistanceBetweenBstNodes {

    private TreeNode prev = null;
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MinimumDistanceBetweenBstNodes m = new MinimumDistanceBetweenBstNodes();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        System.out.println(m.minDiffInBST(node));
    }

    private int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return min;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        // 中序遍历节点的值是有序的
        if (prev != null) {
            min = Integer.min(min, root.val - prev.val);
        }
        prev = root;
        inorderTraversal(root.right);
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
