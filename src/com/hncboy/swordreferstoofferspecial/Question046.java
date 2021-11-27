package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2021/11/27 16:06
 * @description 剑指 Offer II 046.二叉树的右侧视图
 * 
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 * 示例 3:
 * 输入: []
 * 输出: []
 *
 * 提示:
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100 
 *
 * 注意：本题与主站 199 题 {@link com.hncboy.BinaryTreeRightSideView}
 * 相同：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/WNC0Lk
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question046 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightValueList = new ArrayList<>();
        if (root == null) {
            return rightValueList;
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

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (i == count - 1) {
                    rightValueList.add(node.val);
                }
            }
        }

        return rightValueList;
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
