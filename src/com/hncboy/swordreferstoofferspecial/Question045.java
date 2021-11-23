package com.hncboy.swordreferstoofferspecial;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2021/11/23 9:37
 * @description 剑指 Offer II 045.二叉树最底层最左边的值
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 *
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 * 提示:
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1 
 *
 * 注意：本题与主站 513 题 {@link com.hncboy.FindBottomLeftTreeValue}
 * 相同： https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *
 * 通过次数 4,276 提交次数 5,287
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/LwUNpT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question045 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 存储每一层最左边的值
        int leftValue = root.val;

        // 层序遍历
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int count = queue.size();

            leftValue = queue.peek().val;

            // 对每一层的元素进行遍历
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return leftValue;
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
