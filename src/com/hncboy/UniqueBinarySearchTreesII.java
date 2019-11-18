package com.hncboy;


import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/11/18 8:25
 * @description 95.不同的二叉搜索树 II
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
        System.out.println(u.generateTrees(3));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    private List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);

        // 遍历包含 1-n 个节点的树情况
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int root = 1; root <= i; root++) {
                // left 为 root 的左节点数
                int left = root - 1;
                // right 为 root 的右节点数
                int right = i - root;
                // 遍历左右子树节点
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode node = new TreeNode(root);
                        // 左子树直接连接
                        node.left = leftTree;
                        // 右子树根据 root 值重新构建
                        node.right = clone(rightTree, root);
                        dp[i].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    /**
     * 根据偏移量重新构建右子树
     *
     * @param n
     * @param offset
     * @return
     */
    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    private List<TreeNode> generateTrees3(int n) {
        return n == 0 ? new ArrayList<>() : getResult(1, n);
    }

    private List<TreeNode> getResult(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // 无节点
        if (start > end) {
            result.add(null);
            return result;
        }

        // 一个节点
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i <= end; i++) {
            // 左子树
            List<TreeNode> leftTree = getResult(start, i - 1);
            // 右子树
            List<TreeNode> rightTree = getResult(i + 1, end);
            // 遍历左右子树
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    // 合并左右子树
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }

        return result;
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
