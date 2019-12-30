package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * @description 1305.���ö����������е�����Ԫ��
 *
 * ����root1 �� root2�����ö�����������
 * ���㷵��һ���б����а����������е������������� ���� ����.
 *
 * ʾ�� 1��
 * ���룺root1 = [2,1,4], root2 = [1,0,3]
 * �����[0,1,1,2,3,4]
 * 
 * ʾ�� 2��
 * ���룺root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * �����[-10,0,0,1,2,5,7,10]
 * 
 * ʾ�� 3��
 * ���룺root1 = [], root2 = [5,1,7,0,2]
 * �����[0,1,2,5,7]
 * 
 * ʾ�� 4��
 * ���룺root1 = [0,-10,10], root2 = []
 * �����[-10,0,10]
 * 
 * ʾ�� 5��
 * ���룺root1 = [1,null,8], root2 = [8,1]
 * �����[1,1,8,8]
 *
 * ��ʾ��
 * ÿ���������5000���ڵ㡣
 * ÿ���ڵ��ֵ��[-10^5, 10^5]֮�䡣
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
     * �������-�ݹ�
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
     * �������-ջ����
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
