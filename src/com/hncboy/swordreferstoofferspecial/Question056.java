package com.hncboy.swordreferstoofferspecial;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author hncboy
 * @date 2021/12/9 9:22
 * @description 剑指 Offer II 056.二叉搜索树中两个节点之和
 * 
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。
 * 假设二叉搜索树中节点的值均唯一。
 *
 * 示例 1：
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 
 * 示例 2：
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 * 提示：
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 *  
 * 注意：本题与主站 653 题 {@link com.hncboy.TwoSumIvInputIsABst} 相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/opLdQZ
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question056 {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 层序遍历
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int count = queue.size();

            // 对每一层的元素进行遍历
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();

                if (set.contains(node.val)) {
                    return true;
                }
                set.add(k - node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return false;
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
