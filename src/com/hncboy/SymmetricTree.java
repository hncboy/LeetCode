package com.hncboy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/10/10 8:29
 * @description 101.对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(4);
        node1.right = new TreeNode(2);
        node1.right.left = new TreeNode(4);
        node1.right.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(9);
        node2.left = new TreeNode(25);
        node2.right = new TreeNode(25);
        node2.left.right = new TreeNode(-95);
        node2.right.left = new TreeNode(-95);
        node2.right.right = new TreeNode(4);

        System.out.println(new SymmetricTree().isSymmetric2(node1));
        System.out.println(new SymmetricTree().isSymmetric2(node2));
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node1 =queue.poll();
            TreeNode node2 =queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    private boolean isSymmetric1(TreeNode root) {
        return isSymmetric1(root, root);
    }

    private boolean isSymmetric1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val)
                && isSymmetric1(root1.left, root2.right)
                && isSymmetric1(root1.right, root2.left);
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
