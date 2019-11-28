package com.hncboy;

import java.util.HashMap;

/**
 * @author hncboy
 * @date 2019/11/28 14:33
 * @description 106.从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(c.buildTree(inorder, postorder));
    }

    private TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length, 0, inorderMap);
    }

    private TreeNode helper(int[] postorder, int postStart, int postEnd, int inStart, HashMap<Integer, Integer> inorderMap) {
        if (postStart == postEnd) {
            return null;
        }

        // 从后序遍历的最后一个节点构造根节点
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        // 从中序遍历 map 中取出根节点对应的位置
        int iRoot = inorderMap.get(root.val);
        // 从中序遍历中计算根节点与第一个节点的距离，也就是左子树的长度
        int leftNum = iRoot - inStart;
        // 递归构造左子树：leftNum 为左子树的长度，inStart 为当前左子树的最左节点
        root.left = helper(postorder, postStart, postStart + leftNum, inStart, inorderMap);
        // 递归构造右子树：preEnd - (postStart + leftNum + 1) 为右子树长度，iRoot + 1 为当前右子树的最左节点
        root.right = helper(postorder, postStart + leftNum, postEnd - 1, iRoot + 1, inorderMap);
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
