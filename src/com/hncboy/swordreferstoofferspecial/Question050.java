package com.hncboy.swordreferstoofferspecial;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2021/11/30 9:14
 * @description 剑指 Offer II 050.向下的路径节点之和
 * 
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 *
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109 
 * -1000 <= targetSum <= 1000 
 *
 * 注意：本题与主站 437 题相同 {@link com.hncboy.PathSumIII}
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 通过次数 3,342 提交次数 5,527
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/6eUYwP
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question050 {

    public int pathSum(TreeNode root, int targetSum) {
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
