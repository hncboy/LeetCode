package com.hncboy.swordreferstooffer;

import java.util.Stack;

/**
 * @author hncboy
 * @date 2021/10/13 8:14
 * @description 剑指 Offer 33.二叉搜索树的后序遍历序列
 * 
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 提示：
 * 数组长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question33 {

    public static void main(String[] args) {
        Question33 q = new Question33();
        System.out.println(q.verifyPostorder2(new int[]{1, 3, 2, 6, 5}));
        System.out.println(q.verifyPostorder2(new int[]{1, 6, 3, 2, 5}));
    }

    /**
     * 单调栈
     * @param postorder postorder
     * @return result
     */
    public boolean verifyPostorder2(int[] postorder) {
        // 单调递增的栈
        Stack<Integer> stack = new Stack<>();
        // 起初根节点设置最大
        int root = Integer.MAX_VALUE;
        // 将后序遍历逆序遍历：root->right->left
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 新一轮的左子树节点如果大于上一轮根节点，则不满足二叉搜索树
            if (postorder[i] > root) {
                return false;
            }
            // 如果栈中元素比遍历的元素大，则说明当前元素是左子树节点，开始往左子树遍历
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                // 比左子树大的节点都被弹出，最后一个弹出的节点即为根节点，也就是这一轮的根节点
                root = stack.pop();
            }
            // 将当前左子树元素入栈，下一轮作为新的根节点
            stack.add(postorder[i]);
        }
        return true;
    }

    /**
     * 递归分治
     *
     * @param postorder postorder
     * @return result
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        // 终止条件
        if (i >= j) {
            return true;
        }

        // 左子树节点
        int p = i;
        // 遍历找到右子树节点
        while (postorder[p] < postorder[j]) {
            p++;
        }

        // 右子树节点
        int m = p;
        // 遍历找到根节点
        while (postorder[p] > postorder[j]) {
            p++;
        }

        // 根节点是否正确 && 左子树是否正确 && 右子树是否正确
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
