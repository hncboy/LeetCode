package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/1/11 22:26
 * @description 1315.祖父节点值为偶数的节点和
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 示例：
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *
 * 提示：
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */
public class SumOfNodesWithEvenValuedGrandparent {

    private int sum = 0;

    public static void main(String[] args) {
        SumOfNodesWithEvenValuedGrandparent s = new SumOfNodesWithEvenValuedGrandparent();
        TreeNode node = s.new TreeNode(6);
        node.left = s.new TreeNode(7);
        node.left.left = s.new TreeNode(2);
        node.left.left.left = s.new TreeNode(9);
        node.left.right = s.new TreeNode(7);
        node.left.right.left = s.new TreeNode(1);
        node.left.right.right = s.new TreeNode(4);
        node.right = s.new TreeNode(8);
        node.right.left = s.new TreeNode(1);
        node.right.right = s.new TreeNode(3);
        node.right.right.right = s.new TreeNode(5);
        System.out.println(s.sumEvenGrandparent(node));
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandparentHelp(root);
        return sum;
    }

    private void sumEvenGrandparentHelp(TreeNode root) {
        if (root == null) {
            return;
        }
        if ((root.val & 1) == 0) {
            if (root.right != null) {
                if (root.right.left != null) {
                    sum += root.right.left.val;
                }
                if (root.right.right != null) {
                    sum += root.right.right.val;
                }
            }
            if (root.left != null) {
                if (root.left.left != null) {
                    sum += root.left.left.val;
                }
                if (root.left.right != null) {
                    sum += root.left.right.val;
                }
            }
        }
        sumEvenGrandparentHelp(root.left);
        sumEvenGrandparentHelp(root.right);
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    private int sumEvenGrandparent2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean flag = false;

            // 如果是偶数节点，flag = true
            if ((node.val & 1) == 0) {
                flag = true;
            }

            if (node.left != null) {
                // 如果节点值为负数，表示父节点为偶数节点，加上该节点的左节点
                if (node.val < 0) {
                    result += node.left.val;
                }
                // 如果父节点是偶数节点，左节点值改为负数
                if (flag) {
                    node.left.val *= -1;
                }
                queue.add(node.left);
            }

            if (node.right != null) {
                // 如果节点值为负数，表示父节点为偶数节点，加上该节点的右节点
                if (node.val < 0) {
                    result += node.right.val;
                }
                // 如果父节点是偶数节点，右节点值改为负数
                if (flag) {
                    node.right.val *= -1;
                }
                queue.add(node.right);
            }
        }
        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
