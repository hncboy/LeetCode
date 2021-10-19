package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/19 8:33
 * @description 剑指 Offer 68-II.二叉树的最近公共祖先
 * 
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question68_II {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归左子树节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归右子树节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果 left 和 right 都为 null，说明 root 的左右子树都不包含 p，q
        if (left == null && right == null) {
            return null;
        }

        // 如果 left 为 null，说明 p，q 不在 root 的左子树中，返回 right
        if (left == null) {
            return right;
        }

        // 如果 right 为 null，说明 p，q 不在 root 的右子树中，返回 left
        if (right == null) {
            return left;
        }

        // 如果 left 和 right 都不为 null，说明 p，q 在 root 两侧，root 为 p，q 的最近公共祖先
        return root;
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
