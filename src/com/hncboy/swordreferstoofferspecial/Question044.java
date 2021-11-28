package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2021/11/28 12:19
 * @description 剑指 Offer II 044.二叉树每层的最大值
 * 
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 * 示例1：
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 *           1
 *          / \
 *         3   2
 *        / \   \  
 *       5   3   9
 *
 * 示例2：
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 *           1
 *          / \
 *         2   3
 *
 * 示例3：
 * 输入: root = [1]
 * 输出: [1]
 *
 * 示例4：
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:      
 *            1 
 *             \
 *              2
 *
 * 示例5：
 * 输入: root = []
 * 输出: []
 *
 * 提示：
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 *
 * 注意：本题与主站 515 题 {@link com.hncboy.FindLargestValueInEachTreeRow}
 * 相同： https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hPov7L
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question044 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 层序遍历
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int count = queue.size();
            // 在每一层维护一个变量，用于存储最大值
            int max = Integer.MIN_VALUE;

            // 对每一层的元素进行遍历
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 将每一层的最大值添加到结果变量中
            result.add(max);
        }
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
