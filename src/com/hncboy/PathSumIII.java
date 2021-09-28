package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/9/28 8:22
 * @description 437.路径总和 III
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumIII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.right.right = new TreeNode(11);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        PathSumIII p = new PathSumIII();
        System.out.println(p.pathSum1(root, 8) == 3);
        System.out.println(p.pathSum2(root, 8) == 3);
    }

    /**
     * 前缀和
     * 时间复杂度：O(N)O(N)，其中 NN 为二叉树中节点的个数。利用前缀和只需遍历一次二叉树即可。
     * 空间复杂度：O(N)O(N)
     *
     * @param root      root
     * @param targetSum targetSum
     * @return
     */
    private int pathSum2(TreeNode root, int targetSum) {
        // 记录前序遍历从根节点到当前节点路径上所有节点的和，key：节点值和 value：该和值出现的次数
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Integer, Integer> prefix, int current, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 当前节点所在路径上的前缀和
        current += root.val;

        // 获取在当前路径上满足 current - targetSum 的前缀和
        int result = prefix.getOrDefault(current - targetSum, 0);

        // 将当前节点路径的前缀和次数+1
        prefix.put(current, prefix.getOrDefault(current, 0) + 1);
        // 遍历左子树
        result += dfs(root.left, prefix, current, targetSum);
        // 遍历右子树
        result += dfs(root.right, prefix, current, targetSum);
        // 移除当前节点的前缀和，避免影响上一层
        prefix.put(current, prefix.getOrDefault(current, 0) - 1);

        return result;
    }

    /**
     * DFS
     * 时间复杂度：O(N^2)，其中 NN 为该二叉树节点的个数。对于每一个节点，求以该节点为起点的路径数目时，
     * 则需要遍历以该节点为根节点的子树的所有节点，因此求该路径所花费的最大时间为 O(N)O(N)，我们会对每个节点都求一次以该节点为起点的路径数目，因此时间复杂度为 O(N^{2})O(N
     * 空间复杂度：O(N)，考虑到递归需要在栈上开辟空间。
     *
     * @param root      root
     * @param targetSum targetSum
     * @return
     */
    private int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        // 从根节点开始遍历
        int result = rootSum(root, targetSum);
        // 从根节点的左节点开始遍历
        result += pathSum1(root.left, targetSum);
        // 从根节点的右节点开始遍历
        result += pathSum1(root.right, targetSum);
        return result;
    }

    private int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        int val = root.val;
        if (val == targetSum) {
            result++;
        }

        result += rootSum(root.left, targetSum - val);
        result += rootSum(root.right, targetSum - val);
        return result;
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
