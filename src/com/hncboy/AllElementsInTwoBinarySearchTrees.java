package com.hncboy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * 1305.���ö����������е�����Ԫ��
 *
 * ���� root1 �� root2 �����ö��������������㷵��һ���б����а��� ������ �е������������� ���� ����.
 *
 * ʾ�� 1��
 * ���룺root1 = [2,1,4], root2 = [1,0,3]
 * �����[0,1,1,2,3,4]
 *
 * ʾ�� 2��
 * ���룺root1 = [1,null,8], root2 = [8,1]
 * �����[1,1,8,8]
 *
 * ��ʾ��
 * ÿ�����Ľڵ����� [0, 5000] ��Χ��
 * -105 <= Node.val <= 105
 * ͨ������ 31,106 �ύ���� 40,098
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
