package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * @description 1305.两棵二叉搜索树中的所有元素
 *
 * 给你root1 和 root2这两棵二叉搜索树。
 * 请你返回一个列表，其中包含两棵树中的所有整数并按 升序 排序。.
 *
 * 示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 
 * 示例 2：
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 
 * 示例 3：
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 
 * 示例 4：
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 
 * 示例 5：
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *
 * 提示：
 * 每棵树最多有5000个节点。
 * 每个节点的值在[-10^5, 10^5]之间。
 */
public class AllElementsInTwoBinarySearchTrees {

    public static void main(String[] args) {
        AllElementsInTwoBinarySearchTrees a = new AllElementsInTwoBinarySearchTrees();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        System.out.println(a.getAllElements(root1, root2));
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal1(root1, result);
        inorderTraversal1(root2, result);
        Collections.sort(result);
        return result;
    }

    /**
     * 中序遍历-递归
     *
     * @param root
     * @param result
     */
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            inorderTraversal(root.left, result);
            inorderTraversal(root.right, result);
        }
    }


    /**
     * 中序遍历-栈迭代
     *
     * @param root
     * @return
     */
    private void inorderTraversal1(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
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
