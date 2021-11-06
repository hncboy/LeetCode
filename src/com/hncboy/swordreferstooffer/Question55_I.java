package com.hncboy.swordreferstooffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2021/10/7 10:13
 * @description 剑指 Offer 55-I.二叉树的深度
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 提示：
 * 节点总数 <= 10000
 * 注意：本题与主站 104 题 {@link com.hncboy.MaximumDepthOfBinaryTree}
 * 相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question55_I {

    /**
     * 迭代
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};

        int depth = 0;
        while (!queue.isEmpty()) {
            // 获取当前这层的数量
            int currentSize = queue.size();
            while (currentSize-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 递归
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
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
