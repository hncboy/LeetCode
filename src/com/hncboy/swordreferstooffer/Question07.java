package com.hncboy.swordreferstooffer;


import java.util.Stack;

/**
 * @author hncboy
 * @date 2021/9/26 12:33
 * @description 剑指 Offer 07.重建二叉树
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 注意：本题与主站 105 题 {@link com.hncboy.ConstructBinaryTreeFromPreorderAndInorderTraversal}
 * 重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
