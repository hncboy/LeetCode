package com.hncboy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hncboy
 * @date 2019/11/1 8:25
 * @description 100.相同的树
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = null;
        q.right = new TreeNode(2);

        System.out.println(new SameTree().isSameTree2(p, q));
    }

    private boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }

    private boolean isSameTree1(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode node1 = pQueue.poll();
            TreeNode node2 = qQueue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.val != node2.val) {
                return false;
            }

            pQueue.add(node1.left);
            pQueue.add(node1.right);
            qQueue.add(node2.left);
            qQueue.add(node2.right);
        }

        return pQueue.isEmpty() == qQueue.isEmpty();
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
