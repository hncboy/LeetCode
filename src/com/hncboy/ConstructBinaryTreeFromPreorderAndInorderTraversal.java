package com.hncboy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/28 11:47
 * @description 105.从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(c.buildTree(preorder, inorder));
    }

    /**
     * 迭代
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private TreeNode buildTree2(int[] preorder, int[] inorder) {
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

    /**
     * 递归
     *
     * @param preorder
     * @param inorder
     * @return
     */
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, 0, inorderMap);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int inStart, HashMap<Integer, Integer> inorderMap) {
        if (preStart == preEnd) {
            return null;
        }

        // 从前序遍历的第一个节点构造根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 从中序遍历 map 中取出根节点对应的位置
        int iRoot = inorderMap.get(root.val);
        // 从中序遍历中计算根节点与第一个节点的距离，也就是左子树的长度
        int leftNum = iRoot - inStart;
        // 递归构造左子树：leftNum 为左子树的长度，inStart 为当前左子树的最左节点
        root.left = helper(preorder, preStart + 1, preStart + leftNum + 1, inStart, inorderMap);
        // 递归构造右子树：preEnd - (preStart + leftNum + 1) 为右子树长度，iRoot + 1 为当前右子树的最左节点
        root.right = helper(preorder, preStart + leftNum + 1, preEnd, iRoot + 1, inorderMap);
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
