package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2020/2/2 14:44
 * @description 1339.分裂二叉树的最大乘积
 *
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 *
 * 示例 2：
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 *
 * 示例 3：
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 *
 * 示例 4：
 * 输入：root = [1,1]
 * 输出：1
 *
 * 提示：
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 */
public class MaximumProductOfSplittedBinaryTree {

    private Map<TreeNode, Long> nodeValueMap = new HashMap<>();
    private long max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaximumProductOfSplittedBinaryTree m = new MaximumProductOfSplittedBinaryTree();
        TreeNode node1 = m.new TreeNode(1);
        node1.left = m.new TreeNode(2);
        node1.left.left = m.new TreeNode(4);
        node1.left.right = m.new TreeNode(5);
        node1.right = m.new TreeNode(3);
        node1.right.right = m.new TreeNode(6);

        TreeNode node2 = m.new TreeNode(1);
        node2.right = m.new TreeNode(2);
        node2.right.left = m.new TreeNode(3);
        node2.right.right = m.new TreeNode(4);
        node2.right.right.left = m.new TreeNode(5);
        node2.right.right.right = m.new TreeNode(6);

        System.out.println(m.maxProduct(node1));
        m.nodeValueMap = new HashMap<>();
        m.max = Integer.MIN_VALUE;
        System.out.println(m.maxProduct(node2));
    }

    private int maxProduct(TreeNode root) {
        nodeValueMap.put(null, 0L);
        maxProduct(root, 0);
        return (int) (max % 1000000007);
    }

    private void maxProduct(TreeNode root, long parentCount) {
        if (root == null) {
            return;
        }
        parentCount += root.val;
        long leftCount = sumNodeValue(root.left);
        long rightCount = sumNodeValue(root.right);
        // 计算以该节点分裂左右子树的乘积
        long maxCount = Math.max((leftCount + parentCount) * rightCount, (rightCount + parentCount) * leftCount);

        // 如果乘积不再大于最大值了，退出递归
        if (maxCount > max) {
            max = maxCount;
            maxProduct(root.left, parentCount + nodeValueMap.get(root.right));
            maxProduct(root.right, parentCount + nodeValueMap.get(root.left));
        }
    }

    /**
     * 计算当前节点子树值的和
     *
     * @param node
     * @return
     */
    private long sumNodeValue(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Long count = nodeValueMap.get(node);
        if (count != null) {
            return count;
        }
        count = node.val + sumNodeValue(node.left) + sumNodeValue(node.right);
        nodeValueMap.put(node, count);

        return count;
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
