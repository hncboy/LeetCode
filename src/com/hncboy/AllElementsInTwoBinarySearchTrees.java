package com.hncboy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/12/29 10:29
 * 1305.两棵二叉搜索树中的所有元素
 *
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 * 示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * 示例 2：
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *
 * 提示：
 * 每棵树的节点数在 [0, 5000] 范围内
 * -105 <= Node.val <= 105
 * 通过次数 31,106 提交次数 40,098
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
