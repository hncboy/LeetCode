package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/12 13:31
 * @description 剑指 Offer II 051.节点之和最大的路径
 * 
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * 提示：
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 *
 * 注意：本题与主站 124 题 {@link com.hncboy.BinaryTreeMaximumPathSum} 相同： https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 通过次数 2,907 提交次数 7,068
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jC7MId
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question051 {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return result;
    }

    public int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 子树路径和为负的话将该子树的值置为 0，表示不包含该子树
        int leftMax = Math.max(0, getMax(root.left));
        int rightMax = Math.max(0, getMax(root.right));
        // 取当该节点包含左右子树的路径和当前的最大路径中的最大值
        result = Math.max(result, root.val + leftMax + rightMax);
        // 当前节点值 + 左右子树中最大的节点和
        return Math.max(leftMax, rightMax) + root.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
