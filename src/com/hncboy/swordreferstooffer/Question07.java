package com.hncboy.swordreferstooffer;


import java.util.Stack;

/**
 * @author hncboy
 * @date 2021/9/26 12:33
 * @description 剑指 Offer 07.重建二叉树
 * {@link com.hncboy.ConstructBinaryTreeFromPreorderAndInorderTraversal}
 */
public class Question07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int pre = 0;
        int in = 0;

        // 前序遍历的第一个节点作为根节点
        TreeNode root = new TreeNode(preorder[pre++]);
        TreeNode currRoot = root;
        Stack<TreeNode> roots = new Stack<>();
        roots.add(currRoot);

        while (pre < preorder.length) {
            // 如果当前根节点值与中序遍历的节点值一样
            if (currRoot.val == inorder[in]) {
                // 正序遍历中序遍历的数组，倒序从栈中取出已经遍历过的根节点
                // 找到最后一次相等的位置的根节点，说明该根节点有右子树需要连接
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    currRoot = roots.pop();
                    in++;
                }

                // 将前序遍历的节点作为右子树节点插入，更新当前根节点
                currRoot.right = new TreeNode(preorder[pre]);
                currRoot = currRoot.right;
                roots.push(currRoot);
                pre++;
            } else {
                // 将前序遍历的节点作为左子树节点插入，更新当前根节点
                currRoot.left = new TreeNode(preorder[pre]);
                currRoot = currRoot.left;
                roots.push(currRoot);
                pre++;
            }
        }
        return root;
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
