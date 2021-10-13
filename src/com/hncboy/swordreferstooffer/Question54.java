package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/13 9:46
 * @description 剑指 Offer 54.二叉搜索树的第k大节点
 * 
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question54 {

    private int result;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    /**
     * 中序遍历为递增序列
     * 求二叉搜索数第 k 大的节点可以转化为求 中序遍历倒序的第 k 个节点
     *
     * @param root root
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 中序遍历倒序先遍历右子树
        dfs(root.right);

        // 遍历到对应的节点
        if (--k == 0) {
            result = root.val;
            return;
        }

        // 再遍历左子树
        dfs(root.left);
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
