package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2021/12/1 9:19
 * @description 653.两数之和 IV-输入 BST
 * 
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 示例 1：
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 *
 * 示例 2：
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *
 * 示例 3：
 * 输入: root = [2,1,3], k = 4
 * 输出: true
 *
 * 示例 4：
 * 输入: root = [2,1,3], k = 1
 * 输出: false
 *
 * 示例 5：
 * 输入: root = [2,1,3], k = 3
 * 输出: true
 *
 * 提示:
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 *
 * 通过次数 45,362 提交次数 75,552
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumIvInputIsABst {

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
