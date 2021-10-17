package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/17 14:39
 * @description 剑指 Offer 55-II.平衡二叉树
 * 
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，
 * 那么它就是一棵平衡二叉树。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 限制：
 * 0 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110 题 {@link com.hncboy.BalancedBinaryTree}
 * 相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question55_II {

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 后序遍历 + 剪枝 （从底至顶）
     */
    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 获取左子树的深度
        int left = recur(root.left);
        // 左子树中不满足平衡二叉树
        if(left == -1) {
            return -1;
        }

        // 获取右子树的深度
        int right = recur(root.right);
        // 右子树中不满足平衡二叉树
        if(right == -1) {
            return -1;
        }

        // 计算左右子树的深度差并返回
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
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
