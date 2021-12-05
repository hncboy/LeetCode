package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/12/5 15:35
 * @description 剑指 Offer II 053.二叉搜索树中的中序后继
 * 
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 * 示例 1：
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 *
 * 提示：
 * 树中节点的数目在范围 [1, 104] 内。
 * -105 <= Node.val <= 105
 * 树中各节点的值均保证唯一。
 *
 * 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-bst/
 * 通过次数 4,790 提交次数 7,467
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/P5rCT8
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question053 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        // 根据二叉搜索数的性质二分查找
        while (root != null) {
            // 如果当前节点大于 p 节点的值，则搜索左子树
            if (root.val > p.val) {
                // result 节点存储比 p 节点大的值
                result = root;
                root = root.left;
            } else {
                // 如果当前节点小于 p 节点的值，则搜索右子树
                root = root.right;
            }
        }
        return result;
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
